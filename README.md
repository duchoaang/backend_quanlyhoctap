# Mô tả
Đây là phần backend của dự án hệ thống hỗ trợ học tập CodeHeroes, để có thể chạy dự án, bạn làm theo các bước sau
# Tạo cơ sở dữ liệu
1. Đầu tiên mọi người clone dự án về với lệnh git clone, sau đó trong source sẽ có thư mục sql_scripts chứa những file scripts sql, mọi người lấy file này sau đó mở Workbench lên.
2. Sau khi mở Workbench mọi người vào mục Server trên thanh công cụ -> Data import, mọi người chọn Import from Dump Project Folder, sau đó chọn Folder sql_scripts vừa clone về.
3. Sau khi import xong mọi người ấn Start import, workbench sẽ tự động chạy và tạo dữ liệu cho dự án.
# Khởi chạy phần backend dự án
1. Sau khi xong phần data, mọi người mở dự án lên (khuyến khích dùng InteliJ IDEA).
2. Sau khi mở xong, mọi người build lại dự án để lấy các mô-đun từ các thư viện về.
3. Cuối cùng mọi người chỉ ấn chạy dự án (Shift + F10).
4.**Lưu ý : Hệ thống sẽ chạy với port 8081, nếu mọi người muốn đổi port khác hoặc port bị trùng thì vào file application.properties chỉnh dòng server.port thành port mọi người chạy được.**
   
