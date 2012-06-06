package com.twitter.corpus.data;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;

import com.google.common.base.Preconditions;

public class HtmlStatus implements Writable {
  // We want to keep track of version to future-proof.
  private static final byte VERSION = 1;

  private byte version;
  private int httpStatusCode;
  private long timestamp;
  private String html;

  public HtmlStatus() {
    this.version = VERSION;
  }

  public HtmlStatus(int httpStatusCode, long timestamp, String html) {
    this.version = VERSION;
    this.httpStatusCode = httpStatusCode;
    this.timestamp = timestamp;
    this.html = Preconditions.checkNotNull(html);
  }

  public int getHttpStatusCode() {
    return httpStatusCode;
  }

  public long getTimestamp() {
    return timestamp;
  }

  public String getHtml() {
    return html;
  }

  /**
   * Deserializes the object.
   */
  public void readFields(DataInput in) throws IOException {
    this.version = in.readByte();
    this.httpStatusCode = in.readInt();
    this.timestamp = in.readLong();
//    this.html = in.readUTF(); // in accordance with the write() method
    byte[] bytes = new byte[in.readInt()];
    in.readFully(bytes);
    this.html = new String(bytes, "utf-8");
  }

  /**
   * Serializes this object.
   */
  public void write(DataOutput out) throws IOException {
    out.writeByte(version);
    out.writeInt(httpStatusCode);
    out.writeLong(timestamp);
//    out.writeUTF(html); // there is a limitation of 64k bytes for writeUTF()
    byte[] bytes = html.getBytes("utf-8");
    out.writeInt(bytes.length);
    out.write(bytes);
  }

  @Override
  public HtmlStatus clone() {
    return new HtmlStatus(httpStatusCode, timestamp, html);
  }

  @Override
  public String toString() {
    return String.format("[Fetched at %d with status %d:\n%s]\n", timestamp, httpStatusCode, html);
  }
}
