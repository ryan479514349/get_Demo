/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-12-04 03:00:25 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("     \r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<meta name=\"renderer\" content=\"webkit|ie-comp|ie-stand\">\r\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no\" />\r\n");
      out.write("<meta http-equiv=\"Cache-Control\" content=\"no-siteapp\" />\r\n");
      out.write("<LINK rel=\"Bookmark\" href=\"/favicon.ico\" >\r\n");
      out.write("<LINK rel=\"Shortcut Icon\" href=\"/favicon.ico\" />\r\n");
      out.write("<!--[if lt IE 9]>\r\n");
      out.write("<script type=\"text/javascript\" src=\"lib/html5.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"lib/respond.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"lib/PIE_IE678.js\"></script>\r\n");
      out.write("<![endif]-->\r\n");
      out.write("<link href=\"css/H-ui.min.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link href=\"css/H-ui.admin.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link href=\"skin/default/skin.css\" rel=\"stylesheet\" type=\"text/css\" id=\"skin\" />\r\n");
      out.write("<link href=\"lib/Hui-iconfont/1.0.1/iconfont.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<!--[if IE 6]>\r\n");
      out.write("<script type=\"text/javascript\" src=\"http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js\" ></script>\r\n");
      out.write("<script>DD_belatedPNG.fix('*');</script>\r\n");
      out.write("<![endif]-->\r\n");
      out.write("<title>H-ui.admin v2.3</title>\r\n");
      out.write("<meta name=\"keywords\" content=\"H-ui.admin v2.3,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载\">\r\n");
      out.write("<meta name=\"description\" content=\"H-ui.admin v2.3，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<header class=\"Hui-header cl\"> <a class=\"Hui-logo l\" title=\"H-ui.admin v2.3\" href=\"/\">H-ui.admin</a> <a class=\"Hui-logo-m l\" href=\"/\" title=\"H-ui.admin\">H-ui</a> <span class=\"Hui-subtitle l\">V2.3</span>\r\n");
      out.write("\t<nav class=\"mainnav cl\" id=\"Hui-nav\">\r\n");
      out.write("\t\t<ul>\r\n");
      out.write("\t\t\t<li class=\"dropDown dropDown_click\"><a href=\"javascript:;\" class=\"dropDown_A\"><i class=\"Hui-iconfont\">&#xe600;</i> 新增 <i class=\"Hui-iconfont\">&#xe6d5;</i></a>\r\n");
      out.write("\t\t\t\t<ul class=\"dropDown-menu radius box-shadow\">\r\n");
      out.write("\t\t\t\t\t<li><a href=\"javascript:;\" onclick=\"article_add('添加资讯','article-add.html')\"><i class=\"Hui-iconfont\">&#xe616;</i> 资讯</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"javascript:;\" onclick=\"picture_add('添加资讯','picture-add.html')\"><i class=\"Hui-iconfont\">&#xe613;</i> 图片</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"javascript:;\" onclick=\"product_add('添加资讯','product-add.html')\"><i class=\"Hui-iconfont\">&#xe620;</i> 产品</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"javascript:;\" onclick=\"member_add('添加用户','member-add.html','','510')\"><i class=\"Hui-iconfont\">&#xe60d;</i> 用户</a></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t</nav>\r\n");
      out.write("\t<ul class=\"Hui-userbar\">\r\n");
      out.write("\t\t<li>超级管理员</li>\r\n");
      out.write("\t\t<li class=\"dropDown dropDown_hover\"><a href=\"#\" class=\"dropDown_A\">admin <i class=\"Hui-iconfont\">&#xe6d5;</i></a>\r\n");
      out.write("\t\t\t<ul class=\"dropDown-menu radius box-shadow\">\r\n");
      out.write("\t\t\t\t<li><a href=\"#\">个人信息</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"#\">切换账户</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"#\">退出</a></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</li>\r\n");
      out.write("\t\t<li id=\"Hui-msg\"> <a href=\"#\" title=\"消息\"><span class=\"badge badge-danger\">1</span><i class=\"Hui-iconfont\" style=\"font-size:18px\">&#xe68a;</i></a> </li>\r\n");
      out.write("\t\t<li id=\"Hui-skin\" class=\"dropDown right dropDown_hover\"><a href=\"javascript:;\" title=\"换肤\"><i class=\"Hui-iconfont\" style=\"font-size:18px\">&#xe62a;</i></a>\r\n");
      out.write("\t\t\t<ul class=\"dropDown-menu radius box-shadow\">\r\n");
      out.write("\t\t\t\t<li><a href=\"javascript:;\" data-val=\"default\" title=\"默认（黑色）\">默认（黑色）</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"javascript:;\" data-val=\"blue\" title=\"蓝色\">蓝色</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"javascript:;\" data-val=\"green\" title=\"绿色\">绿色</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"javascript:;\" data-val=\"red\" title=\"红色\">红色</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"javascript:;\" data-val=\"yellow\" title=\"黄色\">黄色</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"javascript:;\" data-val=\"orange\" title=\"绿色\">橙色</a></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</li>\r\n");
      out.write("\t</ul>\r\n");
      out.write("\t<a aria-hidden=\"false\" class=\"Hui-nav-toggle\" href=\"#\"></a> </header>\r\n");
      out.write("<aside class=\"Hui-aside\">\r\n");
      out.write("\t<input runat=\"server\" id=\"divScrollValue\" type=\"hidden\" value=\"\" />\r\n");
      out.write("\t<div class=\"menu_dropdown bk_2\">\r\n");
      out.write("\t\t<dl id=\"menu-article\">\r\n");
      out.write("\t\t\t<dt><i class=\"Hui-iconfont\">&#xe616;</i> 资讯管理<i class=\"Hui-iconfont menu_dropdown-arrow\">&#xe6d5;</i></dt>\r\n");
      out.write("\t\t\t<dd>\r\n");
      out.write("\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t<!-- \r\n");
      out.write("\t\t\t\t\t\th-ui前端框架中的超链接要写在_href属性中\r\n");
      out.write("\t\t\t\t\t -->\r\n");
      out.write("\t\t\t\t\t<li><a _href=\"orgController/getOrgPage\" href=\"javascript:void(0)\">组织管理</a></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</dd>\r\n");
      out.write("\t\t</dl>\r\n");
      out.write("\t</div>\r\n");
      out.write("</aside>\r\n");
      out.write("<div class=\"dislpayArrow\"><a class=\"pngfix\" href=\"javascript:void(0);\" onClick=\"displaynavbar(this)\"></a></div>\r\n");
      out.write("<section class=\"Hui-article-box\">\r\n");
      out.write("\t<div id=\"Hui-tabNav\" class=\"Hui-tabNav\">\r\n");
      out.write("\t\t<div class=\"Hui-tabNav-wp\">\r\n");
      out.write("\t\t\t<ul id=\"min_title_list\" class=\"acrossTab cl\">\r\n");
      out.write("\t\t\t\t<li class=\"active\"><span title=\"我的桌面\" data-href=\"welcome.html\">我的桌面</span><em></em></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"Hui-tabNav-more btn-group\"><a id=\"js-tabNav-prev\" class=\"btn radius btn-default size-S\" href=\"javascript:;\"><i class=\"Hui-iconfont\">&#xe6d4;</i></a><a id=\"js-tabNav-next\" class=\"btn radius btn-default size-S\" href=\"javascript:;\"><i class=\"Hui-iconfont\">&#xe6d7;</i></a></div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div id=\"iframe_box\" class=\"Hui-article\">\r\n");
      out.write("\t\t<div class=\"show_iframe\">\r\n");
      out.write("\t\t\t<div style=\"display:none\" class=\"loading\"></div>\r\n");
      out.write("\t\t\t<iframe scrolling=\"yes\" frameborder=\"0\" src=\"welcome.html\"></iframe>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</section>\r\n");
      out.write("<script type=\"text/javascript\" src=\"lib/jquery/1.9.1/jquery.min.js\"></script> \r\n");
      out.write("<script type=\"text/javascript\" src=\"lib/layer/layer.js\"></script> \r\n");
      out.write("<script type=\"text/javascript\" src=\"js/H-ui.js\"></script> \r\n");
      out.write("<script type=\"text/javascript\" src=\"js/H-ui.admin.js\"></script> \r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("/*资讯-添加*/\r\n");
      out.write("function article_add(title,url){\r\n");
      out.write("\tvar index = layer.open({\r\n");
      out.write("\t\ttype: 2,\r\n");
      out.write("\t\ttitle: title,\r\n");
      out.write("\t\tcontent: url\r\n");
      out.write("\t});\r\n");
      out.write("\tlayer.full(index);\r\n");
      out.write("}\r\n");
      out.write("/*图片-添加*/\r\n");
      out.write("function picture_add(title,url){\r\n");
      out.write("\tvar index = layer.open({\r\n");
      out.write("\t\ttype: 2,\r\n");
      out.write("\t\ttitle: title,\r\n");
      out.write("\t\tcontent: url\r\n");
      out.write("\t});\r\n");
      out.write("\tlayer.full(index);\r\n");
      out.write("}\r\n");
      out.write("/*产品-添加*/\r\n");
      out.write("function product_add(title,url){\r\n");
      out.write("\tvar index = layer.open({\r\n");
      out.write("\t\ttype: 2,\r\n");
      out.write("\t\ttitle: title,\r\n");
      out.write("\t\tcontent: url\r\n");
      out.write("\t});\r\n");
      out.write("\tlayer.full(index);\r\n");
      out.write("}\r\n");
      out.write("/*用户-添加*/\r\n");
      out.write("function member_add(title,url,w,h){\r\n");
      out.write("\tlayer_show(title,url,w,h);\r\n");
      out.write("}\r\n");
      out.write("</script> \r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("var _hmt = _hmt || [];\r\n");
      out.write("(function() {\r\n");
      out.write("  var hm = document.createElement(\"script\");\r\n");
      out.write("  hm.src = \"//hm.baidu.com/hm.js?080836300300be57b7f34f4b3e97d911\";\r\n");
      out.write("  var s = document.getElementsByTagName(\"script\")[0]; \r\n");
      out.write("  s.parentNode.insertBefore(hm, s)})();\r\n");
      out.write("var _bdhmProtocol = ((\"https:\" == document.location.protocol) ? \" https://\" : \" http://\");\r\n");
      out.write("document.write(unescape(\"%3Cscript src='\" + _bdhmProtocol + \"hm.baidu.com/h.js%3F080836300300be57b7f34f4b3e97d911' type='text/javascript'%3E%3C/script%3E\"));\r\n");
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
