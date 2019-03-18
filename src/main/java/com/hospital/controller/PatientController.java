package com.hospital.controller;

import com.alibaba.fastjson.JSONObject;
import com.hospital.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PatientController {
    @Autowired
    PatientService patientService;
    @RequestMapping("/admin/patientManage")
    public String patientlist(HttpServletRequest request){
        request.setAttribute("patients",patientService.getAllPatients());
        return "admin/patientManage";
    }
    @RequestMapping(value = "/admin/patient/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public JSONObject delPatient(@PathVariable Integer id){
        JSONObject json=new JSONObject();
        json.put("message",patientService.delPatient(id));
        return json;
    }
}
