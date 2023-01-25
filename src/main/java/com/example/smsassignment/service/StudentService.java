package com.example.smsassignment.service;

import com.example.smsassignment.dto.StudentDTO;
import com.example.smsassignment.entity.Student;
import com.example.smsassignment.repo.StudentRepo;
import com.example.smsassignment.util.VarList;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private ModelMapper modelMapper;

    public String saveStudent(StudentDTO studentDTO){
        if (studentRepo.existsById(studentDTO.getStdID())){
            return VarList.RSP_DUPLICATED;
        }else{
            studentRepo.save(modelMapper.map(studentDTO, Student.class));
            return VarList.RSP_SUCCESS;
        }
    }

    public String updateStudent(StudentDTO studentDTO){
        if (studentRepo.existsById(studentDTO.getStdID())){
            studentRepo.save(modelMapper.map(studentDTO,Student.class));
            return VarList.RSP_SUCCESS;
        }else{
            return VarList.RSP_NO_DATA_FOUND;
        }
    }

    public List<StudentDTO> getAllStudent(){
        List<Student> studentList = studentRepo.findAll();
        return modelMapper.map(studentList, new TypeToken<ArrayList<StudentDTO>>(){

        }.getType());
    }

    public StudentDTO searchStudent(int stdID){
        if (studentRepo.existsById(stdID)){
            Student student = studentRepo.findById(stdID).orElse(null);
            return modelMapper.map(student,StudentDTO.class);
        }else{
            return null;
        }
    }

    public String deleteStudent(int stdID){
        if (studentRepo.existsById(stdID)){
            studentRepo.deleteById(stdID);
            return VarList.RSP_SUCCESS;
        }else{
            return VarList.RSP_NO_DATA_FOUND;
        }
    }

}
