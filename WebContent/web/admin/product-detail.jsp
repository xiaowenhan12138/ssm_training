<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>商品详情</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- page style -->
  <style>
  .my-input{
    width: 22.77777778% !important;
  }
  .my-label{
	width: 10.55555555% !important;
  }
  .my-img{
	padding-right: 2.0% !important;
    padding-left: 8.0% !important;
  }
  .datepicker{
    z-index: 9999 !important;
  }
  </style>
  <!-- Bootstrap 3.3.7 -->
  <link rel="stylesheet" href="../css/bootstrap/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="../css/font-awesome/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="../css/Ionicons/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="../css/AdminLTE/AdminLTE.min.css">
  <!-- AdminLTE Skin -->
  <link rel="stylesheet" href="../css/AdminLTE/skin/skin-blue.min.css">
  <!-- Google Font -->
  <!-- <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic"> -->
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

  <!-- Main Header -->
  <jsp:include page="header.jsp"></jsp:include>
  
  <!-- Left side column. contains the logo and sidebar -->
  <jsp:include page="left.jsp"></jsp:include>
  

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1><small></small></h1>
      <ol class="breadcrumb">
        <li><i class="fa fa-dashboard">&nbsp;商品管理</i></li>
        <li><a href="product-list.html"><i class="fa"></i>所有商品</a></li>
        <li class="active">商品详情</li>
      </ol>
    </section>
    <!-- Main content -->
    <section class="content container-fluid">
      <!-- Horizontal Form -->
      <div class="box box-primary">
        <div class="box-header with-border">
          <h3 class="box-title">详细信息</h3>
        </div>
        <!-- /.box-header -->
        <!-- form start -->
        <form class="form-horizontal" role="form">
          <div class="box-body">
            <div class="form-group">
			  <label for="isbn" class="col-sm-2 control-label my-label">图书编号</label>
              <div class="col-sm-10 my-input">
                <input type="text" class="form-control" name="isbn" id="isbn" value="${requestScope.book.isbn }" readonly>
              </div>
			  <label for="title" class="col-sm-2 control-label my-label">书名</label>
              <div class="col-sm-10 my-input">
                <input type="text" class="form-control" name="title" id="title" value="${requestScope.book.title }" readonly>
              </div>
			  <label for="author" class="col-sm-2 control-label my-label">作者</label>
              <div class="col-sm-10 my-input">
                <input type="text" class="form-control" name="author" id="author" value="${requestScope.book.author }" readonly>
              </div>
            </div>
            <div class="form-group">
			  <label for="price" class="col-sm-2 control-label my-label">价格</label>
              <div class="col-sm-10 my-input">
                <input type="text" class="form-control" name="price" id="price" value="${requestScope.book.price }" readonly>
              </div>
			  <label for="pages" class="col-sm-2 control-label my-label">页数</label>
              <div class="col-sm-10 my-input">
                <input type="text" class="form-control" name="pages" id="pages" value="${requestScope.book.pages }" readonly>
              </div>
			  <label for="words" class="col-sm-2 control-label my-label">字数</label>
              <div class="col-sm-10 my-input">
                <input type="text" class="form-control" name="words" id="words" value="${requestScope.book.words }" readonly>
              </div>
            </div>
            <div class="form-group">
			  <label for="press" class="col-sm-2 control-label my-label">出版社</label>
              <div class="col-sm-10 my-input">
                <input type="text" class="form-control" name="press" id="press" value="${requestScope.book.press }" readonly>
              </div>
			  <label for="edition" class="col-sm-2 control-label my-label">版次</label>
              <div class="col-sm-10 my-input">
                <input type="text" class="form-control" name="edition" id="edition" value="${requestScope.book.edition }" readonly>
              </div>
			  <label for="published" class="col-sm-2 control-label my-label">出版日期</label>
              <div class="col-sm-10 my-input">
                <input type="text" class="form-control" name="published" id="published" value="${requestScope.book.published }" readonly>
              </div>
            </div>
            <div class="form-group">
			  <label for="format" class="col-sm-2 control-label my-label">开本</label>
              <div class="col-sm-10 my-input">
                <input type="text" class="form-control" name="format" id="format" value="${requestScope.book.format }" readonly>
              </div>
			  <label for="packaging" class="col-sm-2 control-label my-label">包装</label>
              <div class="col-sm-10 my-input">
                <input type="text" class="form-control" name="packaging" id="packaging" value="${requestScope.book.packaging }" readonly>
              </div>
			  <label for="form" class="col-sm-2 control-label my-label">用纸</label>
              <div class="col-sm-10 my-input">
                <input type="text" class="form-control" name="form" id="form" value="${requestScope.book.form }" readonly>
              </div>
            </div>
            <div class="form-group">
			  <div class="col-sm-4 my-img">
                <img class="img-responsive" src="../../user/img/goods/${requestScope.book.isbn }/detail1big.jpg" alt="Detail 1 Photo is missing">
              </div>
			  <div class="col-sm-4 my-img">
                <img class="img-responsive" src="../../user/img/goods/${requestScope.book.isbn }/detail2big.jpg" alt="Detail 2 Photo is missing">
              </div>
			  <div class="col-sm-4 my-img">
                <img class="img-responsive" src="../../user/img/goods/${requestScope.book.isbn }/detail3big.jpg" alt="Detail 3 Photo is missing">
              </div>
            </div>
          </div>
          <!-- /.box-body -->
          <div class="box-footer">
          </div>
          <!-- /.box-footer -->
        </form>
      </div>
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

  <!-- Main Footer -->
  <footer class="main-footer">
    <!-- To the right -->
    <div class="pull-right hidden-xs">
      缔造年轻人的中国梦
    </div>
    <!-- Default to the left -->
    <strong>Copyright &copy; 2021 <a href="http://www.tedu.cn">达内教育</a>.</strong> All rights reserved.
  </footer>

  <!-- /.control-sidebar -->
  <!-- Add the sidebar's background. This div must be placed
  immediately after the control sidebar -->
  <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->

<!-- jQuery 3 -->
<script src="../js/jquery/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="../js/bootstrap/bootstrap.min.js"></script>
<!-- AdminLTE App -->
<script src="../js/AdminLTE/adminlte.min.js"></script>
<!-- page script -->
<script>

</script>
</body>
</html>
