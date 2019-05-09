package com.wangdong.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 生成验证码
 * @author wangdong
 *
 */
@WebServlet("/validcode")
public class ValidataServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		OutputStream out = resp.getOutputStream();
		BufferedImage bi = new BufferedImage(120, 20, BufferedImage.TYPE_BYTE_GRAY);
		Graphics g = bi.getGraphics();
		//填充白色背景
		g.setColor(Color.white);
		g.fillRect(0, 0, 120, 20);
		g.setFont(new Font("宋体", Font.BOLD, 16));
		g.setColor(Color.black);
		g.drawString("139-1829-5828", 2, 16);
		//ImageIO工具类将图片bi写入到out流
		ImageIO.write(bi, "jpg", out);	
	}
	
}
