/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-12-08 05:53:35 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.application.menu;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class updateMenu_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<base href=\"");
      out.print(request.getContextPath() + "/");
      out.write("\">\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<link href=\"css/H-ui.min.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link href=\"css/H-ui.admin.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link href=\"lib/icheck/icheck.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link href=\"lib/Hui-iconfont/1.0.1/iconfont.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"lib/zTree/v3/css/zTreeStyle/zTreeStyle.css\" type=\"text/css\">\r\n");
      out.write("<title>添加菜单</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"pd-20\">\r\n");
      out.write("\t<form action=\"\" method=\"post\" class=\"form form-horizontal\" id=\"form-menu-update\">\r\n");
      out.write("\t\t<div class=\"row cl\">\r\n");
      out.write("\t\t\t<label class=\"form-label col-3\"><span class=\"c-red\">*</span>菜单名称：</label>\r\n");
      out.write("\t\t\t<div class=\"formControls col-5\">\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" id=\"menuId\" name=\"menuId\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\">\r\n");
      out.write("\t\t\t\t<input type=\"text\" class=\"input-text\" value=\"\" placeholder=\"\" id=\"menuName\" name=\"menuName\" datatype=\"*2-16\" nullmsg=\"菜单名称不能为空\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"col-4\"> </div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"row cl\">\r\n");
      out.write("\t\t\t\t<label class=\"form-label col-3\"><span class=\"c-red\">*</span>所属目录：</label>\r\n");
      out.write("\t\t\t\t<div class=\"formControls col-5\">\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" class=\"input-text\" value=\"\" placeholder=\"\"\r\n");
      out.write("\t\t\t\t\t\tid=\"parentName\" name=\"menuParentName\" datatype=\"*1-8\"\r\n");
      out.write("\t\t\t\t\t\tnullmsg=\"所属菜单不能为空\" errormsg=\"所属菜单的长度必须是1~8位\" readonly=\"readonly\">\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<input type=\"hidden\" id=\"parentId\" name=\"menuParentId\" >\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<input type=\"button\" class=\"btn btn-default\" value=\"菜单\" onclick=\"getModeTree('menu/findMenuTree')\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"col-4\"></div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"row cl\">\r\n");
      out.write("\t\t\t<label class=\"form-label col-3\"><span class=\"c-red\"></span>路径：</label>\r\n");
      out.write("\t\t\t<div class=\"formControls col-5\">\r\n");
      out.write("\t\t\t\t<input type=\"text\" class=\"input-text\" value=\"\" placeholder=\"\" id=\"menuPath\" name=\"menuPath\" >\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"col-4\"> </div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"row cl\">\r\n");
      out.write("\t\t\t<label class=\"form-label col-3\"><span class=\"c-red\"></span>permissionCode：</label>\r\n");
      out.write("\t\t\t<div class=\"formControls col-5\">\r\n");
      out.write("\t\t\t\t<input type=\"text\" class=\"input-text\" value=\"\" placeholder=\"\" id=\"permissionCode\" name=\"permissionCode\" >\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"col-4\"> </div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"row cl\">\r\n");
      out.write("\t\t\t<label class=\"form-label col-3\"><span class=\"c-red\">*</span>类型：</label>\r\n");
      out.write("\t\t\t\t<div class=\"formControls col-5\"> \r\n");
      out.write("\t\t\t\t\t<span class=\"select-box\" style=\"width:150px;\">\r\n");
      out.write("\t\t\t\t\t\t<select class=\"select\" id=\"menuType\" name=\"menuType\" size=\"1\" datatype=\"*\" nullmsg=\"类型不能为空\">\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"1\" label=\"目录\">\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"2\" label=\"菜单\">\r\n");
      out.write("\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"col-4\"> </div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"row cl\">\r\n");
      out.write("\t\t\t<label class=\"form-label col-3\"><span class=\"c-red\">*</span>状态：</label>\r\n");
      out.write("\t\t\t\t<div class=\"formControls col-5\"> \r\n");
      out.write("\t\t\t\t\t<span class=\"select-box\" style=\"width:150px;\">\r\n");
      out.write("\t\t\t\t\t\t<select class=\"select\" id=\"isPublish\" name=\"isPublish\" size=\"1\" datatype=\"*\" nullmsg=\"状态不能为空\">\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"0\" label=\"启用\">\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"1\" label=\"禁用\">\r\n");
      out.write("\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"col-4\"> </div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"row cl\">\r\n");
      out.write("\t\t\t<label class=\"form-label col-3\">菜单描述：</label>\r\n");
      out.write("\t\t\t<div class=\"formControls col-5\">\r\n");
      out.write("\t\t\t\t<textarea id=\"descContent\" name=\"descContent\" cols=\"\" rows=\"\" class=\"textarea\"  placeholder=\"请输入邮件内容...150个字符以内\" dragonfly=\"true\" onKeyUp=\"textarealength(this,150)\"></textarea>\r\n");
      out.write("\t\t\t\t<p class=\"textarea-numberbar\"><em class=\"textarea-length\">0</em>/150</p>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"col-4\"> </div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"row cl\">\r\n");
      out.write("\t\t\t<div class=\"col-9 col-offset-3\">\r\n");
      out.write("\t\t\t\t<input class=\"btn btn-primary radius\" type=\"submit\" value=\"&nbsp;&nbsp;提交&nbsp;&nbsp;\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</form>\r\n");
      out.write("</div>\r\n");
      out.write("<script type=\"text/javascript\" src=\"lib/jquery/1.9.1/jquery.min.js\"></script> \r\n");
      out.write("<script type=\"text/javascript\" src=\"lib/icheck/jquery.icheck.min.js\"></script> \r\n");
      out.write("<script type=\"text/javascript\" src=\"lib/Validform/5.3.2/Validform.min.js\"></script> \r\n");
      out.write("<script type=\"text/javascript\" src=\"lib/layer/layer.js\"></script> \r\n");
      out.write("<script type=\"text/javascript\" src=\"js/H-ui.js\"></script> \r\n");
      out.write("<script type=\"text/javascript\" src=\"js/H-ui.admin.js\"></script> \r\n");
      out.write("\t<script type=\"text/javascript\" src=\"lib/zTree/v3/js/jquery.ztree.core-3.5.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/oa_utils.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t$(function(){\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar menu = new Object();\r\n");
      out.write("\t\tmenu.id = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("\t\t$.getJSON(\"menu/getMenuById\", menu, function(data){\r\n");
      out.write("\t\t\tdebugger\r\n");
      out.write("\t\t\t$(\"#menuId\").val(data.menuId);\r\n");
      out.write("\t\t\t$(\"#menuName\").val(data.menuName);\r\n");
      out.write("\t\t\t$(\"#parentId\").val(data.menuParentId);\r\n");
      out.write("\t\t\t$(\"#parentName\").val(data.menuParentName);\r\n");
      out.write("\t\t\t$(\"#menuPath\").val(data.menuPath);\r\n");
      out.write("\t\t\t$(\"#permissionCode\").val(data.permissionCode);\r\n");
      out.write("\t\t\t$(\"#menuType\").val(data.menuType);\r\n");
      out.write("\t\t\t$(\"#isPublish\").val(data.isPublish);\r\n");
      out.write("\t\t\t$(\"#descContent\").val(data.descContent);\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$('.skin-minimal input').iCheck({\r\n");
      out.write("\t\t\tcheckboxClass: 'icheckbox-blue',\r\n");
      out.write("\t\t\tradioClass: 'iradio-blue',\r\n");
      out.write("\t\t\tincreaseArea: '20%'\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$(\"#form-menu-update\").Validform(\r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t\ttiptype : 2,\r\n");
      out.write("\t\t\t\tcallback : function(form) {\r\n");
      out.write("\t\t\t\tdebugger\r\n");
      out.write("\t\t\t\tsubmitForm(\"menu/updateMenu\", form);\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
