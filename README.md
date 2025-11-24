# 🚗 Car Dealership Management System

## 📋 Giới thiệu dự án
Hệ thống quản lý đại lý xe hơi (Car Dealership Management System) là một ứng dụng web được phát triển bằng Java, sử dụng công nghệ JSP/Servlet để quản lý các hoạt động của một đại lý bán xe. Đây là đồ án cuối kỳ môn PRJ301.

### 👥 Thành viên nhóm
- **Trần Quang Huy**
- **Trần Hoàng Huy**

---

## 🎯 Tính năng chính

### 1. 🔐 Quản lý người dùng
- Đăng nhập/Đăng xuất cho nhân viên bán hàng (Sales Person)
- Xác thực và phân quyền người dùng

### 2. 🚙 Quản lý xe (Cars Management)
- **Xem danh sách xe**: Hiển thị thông tin chi tiết các xe trong kho
- **Thêm xe mới**: Đăng ký xe mới vào hệ thống
- **Cập nhật thông tin xe**: Chỉnh sửa thông tin xe (Model, màu sắc, năm sản xuất, giá)
- **Xóa xe**: Xóa xe khỏi hệ thống
- **Tìm kiếm xe**: Tìm kiếm xe theo các tiêu chí khác nhau

### 3. 👤 Quản lý khách hàng (Customer Management)
- Xem danh sách khách hàng
- Thêm khách hàng mới
- Cập nhật thông tin khách hàng
- Xem chi tiết thông tin khách hàng
- Tìm kiếm khách hàng

### 4. 🔧 Quản lý phụ tùng (Parts Management)
- Xem danh sách phụ tùng
- Thêm phụ tùng mới
- Cập nhật thông tin phụ tùng
- Xóa phụ tùng
- Quản lý giá mua và giá bán

### 5. 🎫 Quản lý phiếu dịch vụ (Service Ticket Management)
- Tạo phiếu dịch vụ sửa chữa
- Theo dõi trạng thái sửa chữa
- Quản lý ngày nhận và ngày trả xe

### 6. 📊 Báo cáo & Thống kê (Reports)
- Báo cáo xe bán theo năm
- Thống kê top 3 thợ sửa chữa giỏi nhất
- Các báo cáo tài chính

### 7. 🧾 Quản lý hóa đơn (Invoice Management)
- Tạo hóa đơn cho khách hàng
- Xem danh sách hóa đơn
- Quản lý thông tin thanh toán

---

## 🛠️ Công nghệ sử dụng

### Backend
- **Java** (JDK 8+)
- **JSP/Servlet** - Xử lý logic nghiệp vụ
- **JDBC** - Kết nối cơ sở dữ liệu

### Frontend
- **HTML5/CSS3** - Giao diện người dùng
- **Bootstrap 5.3.3** - Framework CSS
- **JavaScript** - Xử lý tương tác

### Database
- **Microsoft SQL Server** - Hệ quản trị cơ sở dữ liệu
- Database: `Car_Dealership`

### Tools & IDE
- **NetBeans IDE** - Môi trường phát triển
- **Apache Ant** - Build tool
- **Apache Tomcat** - Web server

---

## 📁 Cấu trúc dự án

```
Car_Dealership-main/
├── src/
│   └── java/
│       ├── controller/          # Các Servlet điều khiển
│       │   ├── MainServlet.java
│       │   ├── CarServlet.java
│       │   ├── CreateCarServlet.java
│       │   ├── UpdateCarServlet.java
│       │   ├── DeleteCarServlet.java
│       │   ├── SearchCarServlet.java
│       │   ├── CustomerServlet.java
│       │   ├── LoadCreateTicketServlet.java
│       │   └── ...
│       ├── dao/                 # Data Access Objects
│       │   ├── CarsDAO.java
│       │   ├── CustomerDAO.java
│       │   ├── PartsDAO.java
│       │   ├── ServiceTicketDAO.java
│       │   ├── SalesPersonDAO.java
│       │   └── ReportDAO.java
│       ├── model/               # Các class Model
│       │   ├── Cars.java
│       │   ├── Customer.java
│       │   ├── Parts.java
│       │   ├── SalesPerson.java
│       │   └── ServiceTicket.java
│       └── mylib/               # Thư viện tiện ích
│           └── DBUtils.java
├── web/                         # Giao diện JSP
│   ├── CarPage.jsp
│   ├── CreateCar.jsp
│   ├── UpdateCar.jsp
│   ├── CustomerPage.jsp
│   ├── CreateCustomer.jsp
│   ├── DashboardPartsPage.jsp
│   ├── CreatePartsPage.jsp
│   ├── CreateServiceTicket.jsp
│   ├── ShowAllInvoice.jsp
│   ├── reports.jsp
│   └── ...
├── build.xml                    # Ant build file
└── nbproject/                   # NetBeans project files
```

---

## ⚙️ Cài đặt và Chạy dự án

### Yêu cầu hệ thống
- **JDK**: 8 trở lên
- **IDE**: NetBeans 8.2+ (khuyến nghị)
- **Database**: Microsoft SQL Server 2019+
- **Server**: Apache Tomcat 9.0+

### Các bước cài đặt

#### 1. Clone repository
```bash
git clone https://github.com/chube-coder-2k4/FINAL-PROJECT-PRJ301.git
cd FINAL-PROJECT-PRJ301/Car_Dealership-main/Car_Dealership-main
```

#### 2. Cấu hình Database

**Tạo database trong SQL Server:**
```sql
CREATE DATABASE Car_Dealership;
```

**Cấu hình kết nối trong `DBUtils.java`:**
```java
private static final String DB_NAME = "Car_Dealership";
private static final String USER_NAME = "sa";
private static final String PASSWORD = "12345";  // Thay đổi password của bạn
```

**Cấu trúc các bảng chính:**
- `Cars` - Thông tin xe
- `Customer` - Thông tin khách hàng
- `Parts` - Phụ tùng
- `SalesPerson` - Nhân viên bán hàng
- `ServiceTicket` - Phiếu dịch vụ
- `Mechanic` - Thợ sửa chữa
- `Invoice` - Hóa đơn

#### 3. Mở project trong NetBeans
1. Mở NetBeans IDE
2. File → Open Project
3. Chọn thư mục `Car_Dealership-main`

#### 4. Cấu hình thư viện
- Thêm JDBC Driver cho SQL Server vào project
- Thêm JSTL library nếu chưa có

#### 5. Build và Deploy
```bash
# Build project
ant clean
ant build

# Hoặc Run trực tiếp trong NetBeans
F6 hoặc Run → Run Project
```

#### 6. Truy cập ứng dụng
```
http://localhost:8080/Car_Dealership-main/
```

---

## 🔑 Thông tin đăng nhập

### Tài khoản mặc định (Sales Person)
```
Username: [Cần cấu hình trong database]
Password: [Cần cấu hình trong database]
```

---

## 📊 Database Schema

### Bảng Cars
| Cột | Kiểu dữ liệu | Mô tả |
|-----|-------------|-------|
| carID | VARCHAR | Mã xe (PK) |
| serialNumber | VARCHAR | Số serial |
| model | VARCHAR | Model xe |
| colour | VARCHAR | Màu sắc |
| year | VARCHAR | Năm sản xuất |
| price | VARCHAR | Giá bán |
| isActive | BIT | Trạng thái |

### Bảng Customer
| Cột | Kiểu dữ liệu | Mô tả |
|-----|-------------|-------|
| custID | VARCHAR | Mã khách hàng (PK) |
| custName | VARCHAR | Tên khách hàng |
| phone | VARCHAR | Số điện thoại |
| sex | VARCHAR | Giới tính |
| cusAddress | VARCHAR | Địa chỉ |
| isActive | BIT | Trạng thái |

### Bảng Parts
| Cột | Kiểu dữ liệu | Mô tả |
|-----|-------------|-------|
| partID | VARCHAR | Mã phụ tùng (PK) |
| partName | VARCHAR | Tên phụ tùng |
| purchasePrice | DOUBLE | Giá mua |
| retailPrice | DOUBLE | Giá bán |

---

## 🎨 Giao diện

### Dashboard chính
- Menu điều hướng
- Thống kê tổng quan
- Truy cập nhanh các chức năng

### Quản lý xe
- Bảng danh sách xe với các trường: ID, Serial Number, Model, Color, Year, Price
- Nút thao tác: Update, Delete
- Form tìm kiếm và thêm mới

### Quản lý khách hàng
- Danh sách khách hàng
- Chi tiết thông tin khách hàng
- Form tạo/cập nhật

---

## 🔄 Workflow chính

### Quy trình bán xe
1. Khách hàng đến đại lý
2. Nhân viên tạo/tìm thông tin khách hàng
3. Tìm kiếm xe phù hợp
4. Tạo hóa đơn
5. Hoàn tất giao dịch

### Quy trình dịch vụ sửa chữa
1. Khách hàng đem xe đến
2. Tạo phiếu dịch vụ (Service Ticket)
3. Chọn phụ tùng cần thay
4. Phân công thợ sửa chữa
5. Hoàn thành và thanh toán

---

## 📝 API Endpoints (MainServlet)

| Action | Method | Mô tả |
|--------|--------|-------|
| `LOAD_CARS` | GET | Tải danh sách xe |
| `CREATE_CAR` | POST | Tạo xe mới |
| `UPDATE_CAR` | POST | Cập nhật xe |
| `DELETE_CAR` | POST | Xóa xe |
| `SEARCH_CAR` | GET | Tìm kiếm xe |
| `LOAD_CUSTOMER` | GET | Tải danh sách khách hàng |
| `LOAD_PARTS` | GET | Tải danh sách phụ tùng |
| `CREATE_SERVICE_TICKET` | POST | Tạo phiếu dịch vụ |

---

## 🐛 Xử lý lỗi

### Lỗi thường gặp

**1. Không kết nối được database**
```
Solution: Kiểm tra SQL Server đã chạy, cấu hình DBUtils.java đúng
```

**2. Lỗi 404 - Page not found**
```
Solution: Kiểm tra web.xml và mapping servlet
```

**3. Lỗi authentication**
```
Solution: Kiểm tra session và thông tin đăng nhập
```

---


Nếu bạn muốn đóng góp cho dự án:
1. Fork reposit
---

## 🌟 Acknowledgments

- FPT University
- Giảng viên môn PRJ301
- Tất cả thành viên trong nhóm

---

**© 2024 Car Dealership Management System - PRJ301 Final Project**
