/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-12-06 11:59:54 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.application.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class userAdd_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.print(request.getContextPath()+"/");
      out.write("\">\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<meta name=\"renderer\" content=\"webkit|ie-comp|ie-stand\">\r\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no\" />\r\n");
      out.write("<meta http-equiv=\"Cache-Control\" content=\"no-siteapp\" />\r\n");
      out.write("<!--[if lt IE 9]>\r\n");
      out.write("<script type=\"text/javascript\" src=\"lib/html5.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"lib/respond.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"lib/PIE_IE678.js\"></script>\r\n");
      out.write("<![endif]-->\r\n");
      out.write("<link href=\"css/H-ui.min.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link href=\"css/H-ui.admin.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link href=\"lib/icheck/icheck.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link href=\"lib/Hui-iconfont/1.0.1/iconfont.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<!--[if IE 6]>\r\n");
      out.write("<script type=\"text/javascript\" src=\"http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js\" ></script>\r\n");
      out.write("<script>DD_belatedPNG.fix('*');</script>\r\n");
      out.write("<![endif]-->\r\n");
      out.write("<title>添加管理员</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"pd-20\">\r\n");
      out.write("\t<form action=\"\" method=\"post\" class=\"form form-horizontal\" id=\"form-admin-add\">\r\n");
      out.write("\t\t<div class=\"row cl\">\r\n");
      out.write("\t\t\t<label class=\"form-label col-3\"><span class=\"c-red\">*</span>管理员：</label>\r\n");
      out.write("\t\t\t<div class=\"formControls col-5\">\r\n");
      out.write("\t\t\t\t<input type=\"text\" class=\"input-text\" value=\"\" placeholder=\"\" id=\"user-name\" name=\"user-name\" datatype=\"*2-16\" nullmsg=\"用户名不能为空\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"col-4\"> </div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"row cl\">\r\n");
      out.write("\t\t\t<label class=\"form-label col-3\"><span class=\"c-red\">*</span>初始密码：</label>\r\n");
      out.write("\t\t\t<div class=\"formControls col-5\">\r\n");
      out.write("\t\t\t\t<input type=\"password\" placeholder=\"密码\" autocomplete=\"off\" value=\"\" class=\"input-text\" datatype=\"*6-20\" nullmsg=\"密码不能为空\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"col-4\"> </div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div class=\"row cl\">\r\n");
      out.write("\t\t\t<label class=\"form-label col-3\"><span class=\"c-red\">*</span>性别：</label>\r\n");
      out.write("\t\t\t<div class=\"formControls col-5 skin-minimal\">\r\n");
      out.write("\t\t\t\t<div class=\"radio-box\">\r\n");
      out.write("\t\t\t\t\t<input type=\"radio\" id=\"sex-1\" name=\"sex\" datatype=\"*\" nullmsg=\"请选择性别！\">\r\n");
      out.write("\t\t\t\t\t<label for=\"sex-1\">男</label>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"radio-box\">\r\n");
      out.write("\t\t\t\t\t<input type=\"radio\" id=\"sex-2\" name=\"sex\">\r\n");
      out.write("\t\t\t\t\t<label for=\"sex-2\">女</label>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"col-4\"> </div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"row cl\">\r\n");
      out.write("\t\t\t<label class=\"form-label col-3\"><span class=\"c-red\">*</span>手机：</label>\r\n");
      out.write("\t\t\t<div class=\"formControls col-5\">\r\n");
      out.write("\t\t\t\t<input type=\"text\" class=\"input-text\" value=\"\" placeholder=\"\" id=\"user-tel\" name=\"user-tel\"  datatype=\"m\" nullmsg=\"手机不能为空\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"col-4\"> </div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"row cl\">\r\n");
      out.write("\t\t\t<label class=\"form-label col-3\"><span class=\"c-red\">*</span>邮箱：</label>\r\n");
      out.write("\t\t\t<div class=\"formControls col-5\">\r\n");
      out.write("\t\t\t\t<input type=\"text\" class=\"input-text\" placeholder=\"@\" name=\"email\" id=\"email\" datatype=\"e\" nullmsg=\"请输入邮箱！\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"col-4\"> </div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"row cl\">\r\n");
      out.write("\t\t\t<label class=\"form-label col-3\">角色：</label>\r\n");
      out.write("\t\t\t<div class=\"formControls col-5\"> <span class=\"select-box\" style=\"width:150px;\">\r\n");
      out.write("\t\t\t\t<select class=\"select\" name=\"admin-role\" size=\"1\">\r\n");
      out.write("\t\t\t\t\t<option value=\"0\">超级管理员</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"1\">总编</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"2\">栏目主辑</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"3\">栏目编辑</option>\r\n");
      out.write("\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t</span> </div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"row cl\">\r\n");
      out.write("\t\t\t<label class=\"form-label col-3\">备注：</label>\r\n");
      out.write("\t\t\t<div class=\"formControls col-5\">\r\n");
      out.write("\t\t\t\t<textarea name=\"\" cols=\"\" rows=\"\" class=\"textarea\"  placeholder=\"说点什么...100个字符以内\" dragonfly=\"true\" onKeyUp=\"textarealength(this,100)\"></textarea>\r\n");
      out.write("\t\t\t\t<p class=\"textarea-numberbar\"><em class=\"textarea-length\">0</em>/100</p>\r\n");
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
      out.write("<script type=\"text/javascript\" src=\"lib/layer/1.9.3/layer.js\"></script> \r\n");
      out.write("<script type=\"text/javascript\" src=\"js/H-ui.js\"></script> \r\n");
      out.write("<script type=\"text/javascript\" src=\"js/H-ui.admin.js\"></script> \r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("$(function(){\r\n");
      out.write("\t$('.skin-minimal input').iCheck({\r\n");
      out.write("\t\tcheckboxClass: 'icheckbox-blue',\r\n");
      out.write("\t\tradioClass: 'iradio-blue',\r\n");
      out.write("\t\tincreaseArea: '20%'\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\t$(\"#form-admin-add\").Validform({\r\n");
      out.write("\t\ttiptype:2,\r\n");
      out.write("\t\tcallback:function(form){\r\n");
      out.write("\t\t\tform[0].submit();\r\n");
      out.write("\t\t\tvar index = parent.layer.getFrameIndex(window.name);\r\n");
      out.write("\t\t\tparent.$('.btn-refresh').click();\r\n");
      out.write("\t\t\tparent.layer.close(index);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\r\n");
      out.write("});\r\n");
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
