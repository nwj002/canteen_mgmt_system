package com.canteen.canteen_mgmt_system.Services.impl;

import com.canteen.canteen_mgmt_system.Services.DepartmentService;
import com.canteen.canteen_mgmt_system.config.PasswordEncoderUtill;
import com.canteen.canteen_mgmt_system.dto.DepartmentDto;
import com.canteen.canteen_mgmt_system.entity.Department;
import com.canteen.canteen_mgmt_system.repo.DepartmentRepo;
import com.canteen.canteen_mgmt_system.repo.EmailCredRepo;
import freemarker.template.Configuration;
import freemarker.template.Template;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;


import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;



@Service
@RequiredArgsConstructor

public class DepartmentServiceimpl implements DepartmentService {
    private final DepartmentRepo departmentRepo;
    private final JavaMailSender getJavaMailSender;
    private final EmailCredRepo emailCredRepo;
    private final ThreadPoolTaskExecutor taskExecutor;

    @Autowired
    @Qualifier("emailConfigBean")
    private Configuration emailConfig;
    @Override
    public void saveData(DepartmentDto departmentDto){
        Department department = new Department();
        if(departmentDto.getId()!=null){
            department.setId(departmentDto.getId());
        }
        department.setDepartmentName(PasswordEncoderUtill.getInstance().encode(departmentDto.getDepartmentName()));
        departmentRepo.save(department);

    }
    @Override
    public List<Department> getData(){
        return departmentRepo.findAll();
    }
    @Override
    public Optional<Department> getById(Integer id) {
        return departmentRepo.findById(id);
    }
    @Override
    public Department getByIdNoOps(Integer id) {
        return departmentRepo.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
    }

    @Override
    public void deleteById(Integer id) {
        departmentRepo.deleteById(id);
    }


    @Override
    public void sendEmail() {
        try {
            Map<String, String> model = new HashMap<>();

            MimeMessage message = getJavaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());

            Template template = emailConfig.getTemplate("emailTemp.ftl.html");
            String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);

            mimeMessageHelper.setTo("budhathokijenish111@gmail.com");
            mimeMessageHelper.setText(html, true);
            mimeMessageHelper.setSubject("Registration");
            mimeMessageHelper.setFrom("nwj.shrestha@gmail.com");

            taskExecutor.execute(new Thread() {
                public void run() {
                    getJavaMailSender.send(message);
                }
            });
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

}
