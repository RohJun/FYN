<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="sidebar pe-4 pb-3">
            <nav class="navbar bg-secondary navbar-dark">
                <a href="adminMain.do" class="navbar-brand mx-4 mb-3">
                    <h3 class="text-primary"><i class="fa fa-user-edit me-2"></i>FYN</h3>
                </a>
                <div class="d-flex align-items-center ms-4 mb-4">
                    <div class="position-relative">
                        <img class="rounded-circle" src="admin_img/admin.png" alt="" style="width: 40px; height: 40px;">
                        <div class="bg-success rounded-circle border border-2 border-white position-absolute end-0 bottom-0 p-1"></div>
                    </div>
                    <div class="ms-3">
                        <h6 class="mb-0">Jun Roh</h6>
                        <span>Admin</span>
                    </div>
                </div>
                <div class="navbar-nav w-100">
                    <a href="adminMemberMain.do" class="nav-item nav-link"><i class="fa-solid fa-users me-2"></i>Member</a>
                    <a href="adminNftMain.do" class="nav-item nav-link"><i class="fa fa-chart-bar me-2"></i>NFT</a>
                    <a href="adminNotice.do" class="nav-item nav-link"><i class="fa-solid fa-clipboard-list me-2"></i>Notice</a>
                    
                </div>
            </nav>
        </div>
</body>
</html>