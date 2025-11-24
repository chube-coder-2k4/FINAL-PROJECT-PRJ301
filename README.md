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
- **Xóa xe**: Soft delete - đánh dấu xe không hoạt động
- **Tìm kiếm xe**: Tìm kiếm xe theo serial number, model, hoặc năm sản xuất

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
│       │   ├── LoginServlet.java
│       │   ├── CarServlet.java
│       │   ├── CustomerServlet.java
│       │   └── ...
│       ├── dao/                 # Data Access Objects
│       │   ├── CarsDAO.java
│       │   ├── CustomerDAO.java
│       │   ├── PartsDAO.java
│       │   └── ...
│       ├── model/               # Các class Model/Entity
│       │   ├── Cars.java
│       │   ├── Customer.java
│       │   ├── Parts.java
│       │   └── ...
│       └── mylib/               # Thư viện tiện ích
│           ├── DBUtils.java
│           ├── DatabaseConfig.properties
│           └── DatabaseConfig.properties.template
├── web/                         # Giao diện JSP
│   ├── CarPage.jsp
│   ├── CustomerPage.jsp
│   ├── DashboardPartsPage.jsp
│   └── ...
└── build.xml
```

---

## ⚙️ Cài đặt và Chạy dự án

### Yêu cầu hệ thống
- **JDK**: 8 trở lên
- **IDE**: NetBeans 8.2+ (khuyến nghị)
- **Database**: Microsoft SQL Server 2019+
- **Server**: Apache Tomcat 9.0+
- **JDBC Driver**: Microsoft SQL Server JDBC Driver

### Các bước cài đặt

#### 1. Clone repository
```bash
git clone https://github.com/YOUR_USERNAME/FINAL-PROJECT-PRJ301.git
cd FINAL-PROJECT-PRJ301/Car_Dealership-main/Car_Dealership-main
```

#### 2. Cấu hình Database

**2.1. Tạo database trong SQL Server:**
```sql
CREATE DATABASE Car_Dealership;
GO

USE Car_Dealership;
GO

-- Tạo các bảng (xem file SQL script trong project)
```

**2.2. Cấu hình kết nối database:**

Copy file template và đổi tên:
```bash
cd src/java/mylib/
copy DatabaseConfig.properties.template DatabaseConfig.properties
```

Chỉnh sửa `DatabaseConfig.properties` với thông tin database của bạn:
```properties
db.name=Car_Dealership
db.username=sa
db.password=YOUR_PASSWORD_HERE
db.host=localhost
db.port=1433
```

> ⚠️ **Lưu ý bảo mật**: File `DatabaseConfig.properties` đã được thêm vào `.gitignore` để tránh commit thông tin nhạy cảm lên Git.

#### 3. Cài đặt JDBC Driver

1. Download Microsoft SQL Server JDBC Driver từ [Microsoft Docs](https://docs.microsoft.com/en-us/sql/connect/jdbc/download-microsoft-jdbc-driver-for-sql-server)
2. Thêm file `.jar` vào thư viện của project trong NetBeans:
   - Right-click project → Properties → Libraries → Add JAR/Folder

#### 4. Mở project trong NetBeans
1. Mở NetBeans IDE
2. File → Open Project
3. Chọn thư mục `Car_Dealership-main`

#### 5. Build và Deploy

**Trong NetBeans:**
- Clean & Build: Shift + F11
- Run Project: F6

**Sử dụng Ant (Command line):**
```bash
ant clean
ant build
ant run
```

#### 6. Truy cập ứng dụng
```
http://localhost:8080/Car_Dealership-main/MainServlet?action=HOME
```

---

## 🔑 Thông tin đăng nhập

### Tài khoản mặc định (Sales Person)
Cần tạo tài khoản trong database bảng `SalesPerson`

---

## 🎨 Code Quality Improvements

Dự án đã được refactor với các cải tiến sau:

### ✅ Best Practices được áp dụng:

1. **Try-with-resources** - Tự động đóng database connections, statements, resultsets
2. **Logging** - Sử dụng `java.util.logging` để ghi log thay vì `printStackTrace()`
3. **Constants** - Sử dụng constants cho SQL queries và magic strings
4. **Configuration file** - Database credentials trong properties file thay vì hardcode
5. **Type safety** - Model classes sử dụng kiểu dữ liệu phù hợp (int, BigDecimal) thay vì toàn String
6. **Code reuse** - Helper methods để giảm duplicate code
7. **Better error handling** - Xử lý exceptions cụ thể và có ý nghĩa
8. **Documentation** - JavaDoc cho tất cả public methods
9. **Security** - `.gitignore` để tránh commit sensitive data
10. **Clean code** - Loại bỏ comments mặc định của NetBeans, code dễ đọc hơn

---

## 📝 Database Schema

### Bảng chính:

**Cars**
- `carID` (INT, PK) - ID xe
- `serialNumber` (VARCHAR) - Số serial
- `model` (VARCHAR) - Model xe
- `colour` (VARCHAR) - Màu sắc
- `year` (INT) - Năm sản xuất
- `price` (DECIMAL) - Giá bán
- `isActive` (BIT) - Trạng thái hoạt động

**Customer**
- `customerID` (INT, PK)
- `firstName` (VARCHAR)
- `lastName` (VARCHAR)
- `phone` (VARCHAR)
- `address` (VARCHAR)

**Parts**
- `partID` (INT, PK)
- `partName` (VARCHAR)
- `purchasePrice` (DECIMAL)
- `salePrice` (DECIMAL)

**SalesPerson**
- `salesPersonID` (INT, PK)
- `name` (VARCHAR)
- `phone` (VARCHAR)

---

## 🤝 Contributing

Nếu bạn muốn đóng góp cho dự án:

1. Fork repository
2. Tạo branch mới (`git checkout -b feature/AmazingFeature`)
3. Commit changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to branch (`git push origin feature/AmazingFeature`)
5. Mở Pull Request

---

## 📄 License

Dự án này được phát triển cho mục đích học tập - Đồ án môn PRJ301

---

## 📧 Liên hệ

- **Trần Quang Huy** - [GitHub](https://github.com/chube-coder-2k4)
- **Trần Hoàng Huy**

Project Link: [https://github.com/chube-coder-2k4/FINAL-PROJECT-PRJ301](https://github.com/chube-coder-2k4/FINAL-PROJECT-PRJ301)

---

## 🙏 Acknowledgments

- FPT University
- PRJ301 Course Instructors
- Bootstrap Team
- Microsoft SQL Server Documentation
