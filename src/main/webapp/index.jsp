<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Zomato Admin Dashboard</title>
    <!-- Bootstrap CSS CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .top-banner {
            background-color: #0d6efd;
            color: white;
            padding: 12px 20px;
            font-weight: bold;
            font-size: 20px;
        }
        .section-header {
            background-color: #0d6efd;
            color: white;
            padding: 10px 15px;
            font-weight: bold;
            font-size: 22px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .right-header {
            background-color: #0d6efd;
            color: white;
            padding: 10px;
            text-align: center;
            font-weight: bold;
            font-size: 22px;
        }
    </style>
</head>
<body class="bg-light">

    <!-- Top Full Width Header Banner -->
    <div class="top-banner mb-4">
        ZOMATO ADMIN DASHBOARD
    </div>

    <div class="container-fluid px-4">
        <div class="row g-4">
            
            <!-- Left Side: Restaurant List (col-md-8) -->
            <div class="col-md-8">
                <div class="card border-0 shadow-sm">
                    <div class="section-header">
                        <span>Restaurant List</span>
                        <a href="#" class="btn btn-success btn-sm">+ Add New Restaurant</a>
                    </div>
                    <div class="card-body p-0">
                        <table class="table table-bordered mb-0">
                            <thead class="table-dark">
                                <tr>
                                    <th>ID</th>
                                    <th>Name</th>
                                    <th>Cuisine</th>
                                    <th>Delivery Time</th>
                                    <th>Action</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%-- Yahan par aapka Java loop aayega data iterate karne ke liye --%>
                                <tr>
                                    <td colspan="5" class="text-center py-3 text-secondary">
                                        No Restaurant Found
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

            <!-- Right Side: Add Restaurant Form (col-md-4) -->
            <div class="col-md-4">
                <div class="card border-0 shadow-sm">
                    <div class="right-header">
                        Add Restaurant
                    </div>
                    <div class="card-body p-4 bg-white">
                        <form action="RestaurantController" method="POST">
                            <div class="mb-3">
                                <label class="form-label fw-bold">Restaurant Name</label>
                                <input type="text" name="name" class="form-control" placeholder="Enter Restaurant Name" required>
                            </div>
                            <div class="mb-3">
                                <label class="form-label fw-bold">Cuisine Type</label>
                                <input type="text" name="cuisine" class="form-control" placeholder="Enter Cuisine Type" required>
                            </div>
                            <div class="mb-3">
                                <label class="form-label fw-bold">Delivery Time</label>
                                <input type="text" name="deliveryTime" class="form-control" placeholder="Enter Delivery Time" required>
                            </div>
                            
                            <div class="d-flex justify-content-end gap-2 mt-4">
                                <button type="submit" class="btn btn-success px-3">Save Restaurant</button>
                                <button type="reset" class="btn btn-dark px-3">Cancel</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>

        </div>
    </div>

</body>
</html>