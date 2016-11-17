<%--
  Created by IntelliJ IDEA.
  User: Echoj
  Date: 2016-09-12
  Time: 9:40
  To change this template use File | Settings | File Templates.
--%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.OutputStream"%><%@ page
        contentType="text/html; charset=utf-8"%>
<%
  String fileName = "离职人员名单.xlsx";
  String filePath = "D:\\downLoadExcels\\";
  response.reset();
  response.setContentType("application/x-download");
  response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
  OutputStream os = response.getOutputStream();
  try {
    FileInputStream fis = new FileInputStream(filePath + fileName);
    try {
      byte[] buffer = new byte[1024 * 10];
      for (int read; (read = fis.read(buffer)) != -1;) {
        os.write(buffer, 0, read);
      }
    } finally {
      fis.close();
    }
  } finally {
    os.close();
  }
%>
