package com.ndh.hotrohoctap.controller;



import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.ndh.hotrohoctap.models.DiemMonHoc;
import com.ndh.hotrohoctap.models.User;
import com.ndh.hotrohoctap.repositories.UserRepository;
import com.ndh.hotrohoctap.services.DiemMonHocService;
import com.ndh.hotrohoctap.services.EmailService;
import io.jsonwebtoken.io.IOException;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/pdf")
@RequiredArgsConstructor
public class ApiPdfController {
    private final UserRepository userRepository;
    private final EmailService emailService;
    private final DiemMonHocService diemMonHocService;

    @GetMapping("/nguoidung")
    public void exportToPdf(HttpServletResponse response) throws IOException, DocumentException, java.io.IOException {
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "inline; filename=nguoidung.pdf");

        Document document = new Document();
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();

        List<User> users = (List<User>) userRepository.findAll();

        for (User user : users) {
            document.add(new Paragraph("MSSV: " + user.getMssv()));
            document.add(new Paragraph("Tên: " + user.getName()));
            document.add(new Paragraph("Email: " + user.getEmail()));
            document.add(new Paragraph("Ngày tham gia " + user.getNgayThamGia()));
            document.add(new Paragraph("------------------------------"));
        }


        document.close();
    }
    @GetMapping("/diem")
    public void exportToPdfDiem(@RequestParam("option") String option, HttpServletResponse response) throws IOException, DocumentException, java.io.IOException {
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "inline; filename=nguoidung.pdf");

        Document document = new Document();
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();

        List<DiemMonHoc> diemMonHocs = new ArrayList<>();

        // Truy vấn dữ liệu điểm dựa trên lựa chọn
        if (option.equals("lt5")) {
            diemMonHocs = diemMonHocService.findDiemMonHocByDiemLessThan5();
        } else if (option.equals("gt8")) {
            diemMonHocs = diemMonHocService.findDiemMonHocByDiemGreaterThan8();
        } else {
            diemMonHocs = diemMonHocService.getAllDiemMonHoc();
        }

        for (DiemMonHoc diem : diemMonHocs) {
            document.add(new Paragraph("MSSV: " + diem.getUser().getMssv()));
            document.add(new Paragraph("Tên: " + diem.getUser().getName()));
            document.add(new Paragraph("Môn học: " + diem.getMonHoc().getTenMonHoc()));
            document.add(new Paragraph("Điểm: " + diem.getDiem()));
            document.add(new Paragraph("------------------------------"));
        }

        document.close();
    }
}
