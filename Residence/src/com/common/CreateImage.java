package com.common;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Line2D.Double;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;

public class CreateImage
{
  private String randomStr = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

  private int randomCount = 4;

  private int width = 80;
  private int height = 25;

  private Color background = Color.WHITE;

  private String randomCode = "";

  public CreateImage()
  {
    setRandomCode();
  }

  public CreateImage(String randomStr, int randomCount, int width, int height, Color background)
  {
    this.randomStr = randomStr;
    this.randomCount = randomCount;
    this.width = width;
    this.height = height;
    this.background = background;
    setRandomCode();
  }

  public CreateImage(String randomStr, int randomCount, int width, int height)
  {
    this.randomStr = randomStr;
    this.randomCount = randomCount;
    this.width = width;
    this.height = height;
    setRandomCode();
  }

  public CreateImage(int randomCount, int width, int height)
  {
    this.randomCount = randomCount;
    this.width = width;
    this.height = height;
    setRandomCode();
  }

  public CreateImage(int width, int height)
  {
    this.width = width;
    this.height = height;
    setRandomCode();
  }

  public CreateImage(String randomStr, int randomCount)
  {
    this.randomStr = randomStr;
    this.randomCount = randomCount;
    setRandomCode();
  }

  public CreateImage(String randomStr)
  {
    this.randomStr = randomStr;
    setRandomCode();
  }

  public CreateImage(int randomCount)
  {
    this.randomCount = randomCount;
    setRandomCode();
  }

  public String getRandomStr()
  {
    return this.randomStr;
  }
  public void setRandomStr(String randomStr) {
    this.randomStr = randomStr;
  }
  public int getRandomCount() {
    return this.randomCount;
  }
  public void setRandomCount(int randomCount) {
    this.randomCount = randomCount;
  }
  public int getWidth() {
    return this.width;
  }
  public void setWidth(int width) {
    this.width = width;
  }
  public int getHeight() {
    return this.height;
  }
  public void setHeight(int height) {
    this.height = height;
  }
  public Color getBackground() {
    return this.background;
  }
  public void setBackground(Color background) {
    this.background = background;
  }
  public String getRandomCode() {
    return this.randomCode;
  }
  public void setRandomCode(String randomCode) {
    this.randomCode = randomCode;
  }

  public void setRandomCode()
  {
    StringBuffer buffer = new StringBuffer();
    Random rd = new Random();
    for (int i = 0; i < this.randomCount; i++) {
      String ch = String.valueOf(this.randomStr.charAt(
        rd.nextInt(this.randomStr.length())));
      buffer.append(ch);
    }
    this.randomCode = buffer.toString();
  }

  public Color randomColor()
  {
    Random rd = new Random();
    return new Color(rd.nextInt(256), 
      rd.nextInt(256), 
      rd.nextInt(256));
  }

  public byte[] getRandomImageBytes()
    throws IOException
  {
    byte[] imageBytes = null;

    BufferedImage bufferImage = new BufferedImage(this.width, this.height, 1);

    Graphics2D g = bufferImage.createGraphics();

    g.setColor(this.background);

    g.fillRect(0, 0, this.width, this.height);

    int fontSize = this.height * 4 / 5;

    Random rd = new Random();
    g.setColor(Color.GRAY);

    for (int i = 0; i < 30; i++) {
      int x1 = rd.nextInt(this.width);
      int y1 = rd.nextInt(this.height);
      int x2 = x1 + rd.nextInt(fontSize / 2);
      int y2 = y1 + rd.nextInt(fontSize / 2);
      Line2D line = new Line2D.Double(x1, y1, x2, y2);
      g.drawLine(x1, y1, x2, y2);

      g.setStroke(new BasicStroke(fontSize / 20));
      g.draw(line);
    }

    for (int i = 0; i < 60; i++) {
      int x = rd.nextInt(this.width);
      int y = rd.nextInt(this.height);
      g.setColor(randomColor());
      g.fillOval(x, y, fontSize / 20, fontSize / 20);
    }

    g.setFont(new Font("ºÚÌå", 1, fontSize));
    for (int i = 0; i < this.randomCount; i++) {
      String ch = String.valueOf(this.randomCode.charAt(i));
      g.setColor(randomColor());

      g.drawString(ch, i * fontSize + 5, fontSize - 5 + rd.nextInt(10));
    }

    ByteArrayOutputStream out = new ByteArrayOutputStream();

    ImageIO.write(bufferImage, "PNG", out);

    imageBytes = out.toByteArray();

    return imageBytes;
  }
}