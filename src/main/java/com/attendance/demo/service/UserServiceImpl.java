package com.attendance.demo.service;

import com.attendance.demo.exception.ObjectNotFoundException;
import com.attendance.demo.model.binding.RegisterBindingModel;
import com.attendance.demo.model.binding.SetAttendanceBindingModel;
import com.attendance.demo.model.entity.Enums.RoleEnum;
import com.attendance.demo.model.entity.GradeEntity;
import com.attendance.demo.model.entity.RoleEntity;
import com.attendance.demo.model.entity.UserEntity;
import com.attendance.demo.repository.GradeRepository;
import com.attendance.demo.repository.RoleRepository;
import com.attendance.demo.repository.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final GradeRepository gradeRepository;

    private final PasswordEncoder passwordEncoder;


    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository,
                           GradeRepository gradeRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.gradeRepository = gradeRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserEntity findByEmail(String email) {
        return this.userRepository.findByEmail(email).orElseThrow(
                () -> new UsernameNotFoundException("User with email:" + email + " not found!")
        );
    }

    @Override
    public void registerUser(RegisterBindingModel registerBindingModel) {
        UserEntity user = new UserEntity();
        user.setEgn(registerBindingModel.getEgn());
        user.setEmail(registerBindingModel.getEmail());
        user.setFamilyName(registerBindingModel.getFamilyName());
        user.setPassword(registerBindingModel.getPassword());
        user.setPhoneNumber(registerBindingModel.getPhoneNumber());
        user.setFirstName(registerBindingModel.getFirstName());
        if(this.userRepository.count()==0){
            user.setRoles(List.of(new RoleEntity(RoleEnum.ADMIN), new RoleEntity(RoleEnum.TEACHER)));
        }
    }



    @Override
    public void seedStudents() {

        if(this.userRepository.findByEmail("nedkiivanov@gmail.com").isEmpty()) {

            UserEntity student1 = new UserEntity();
            student1.setRoles(List.of(getRoles(3l)));
            student1.setFirstName("Nedko");
            student1.setFamilyName("Ivanov");
            student1.setEgn("00294423253");
            student1.setEmail("nedkiivanov@gmail.com");
            this.userRepository.save(student1);

        }

        if(this.userRepository.findByEmail("mitkoDMTRV@gmail.com").isEmpty()) {

            UserEntity student2 = new UserEntity();
            student2.setRoles(List.of(getRoles(3l)));
            student2.setFirstName("Mitko");
            student2.setFamilyName("Dimitrov");
            student2.setEgn("002477832053");
            student2.setEmail("mitkoDMTRV@gmail.com");
            this.userRepository.save(student2);
        }

        if(this.userRepository.findByEmail("georgiev02@gmail.com").isEmpty()) {

            UserEntity student3 = new UserEntity();
            student3.setRoles(List.of(getRoles(3l)));
            student3.setFirstName("Ivan");
            student3.setFamilyName("Georgiev");
            student3.setEgn("02279953353");
            student3.setEmail("georgiev02@gmail.com");
            this.userRepository.save(student3);

        }

        if(this.userRepository.findByEmail("todorovTodor@gmail.com").isEmpty()) {

            UserEntity student4 = new UserEntity();
            student4.setRoles(List.of(getRoles(3l)));
            student4.setFirstName("Todor");
            student4.setFamilyName("Todorov");
            student4.setEgn("0009442325453");
            student4.setEmail("todorovTodor@gmail.com");
            this.userRepository.save(student4);

        }

        if(this.userRepository.findByEmail("martinez@gmail.com").isEmpty()) {

            UserEntity student5 = new UserEntity();
            student5.setRoles(List.of(getRoles(3l)));
            student5.setFirstName("Martin");
            student5.setFamilyName("Petrov");
            student5.setEgn("00169844232");
            student5.setEmail("martinez@gmail.com");
            this.userRepository.save(student5);

        }

    }

    @Transactional
    @Override
    public void seedTeachers() {

        if(this.userRepository.findByEmail("first@gmail.com").isEmpty()) {

            UserEntity teacher1 = new UserEntity();
            teacher1.setFirstName("First");
            teacher1.setFamilyName("teacher");
            teacher1.setEgn("9709875687");
            teacher1.setEmail("first@gmail.com");
            teacher1.setRoles(List.of(getRoles(2l),getRoles(1l)));
            teacher1.setPassword(this.passwordEncoder.encode("admin"));
            this.userRepository.save(teacher1);

        }

        if(this.userRepository.findByEmail("second@gmail.com").isEmpty()) {

            UserEntity teacher2 = new UserEntity();
            teacher2.setFirstName("Second");
            teacher2.setFamilyName("teacher");
            teacher2.setEgn("7711875687");
            teacher2.setEmail("second@gmail.com");
            teacher2.setRoles(List.of(getRoles(2l)));
            teacher2.setPassword(this.passwordEncoder.encode("123456789"));
            this.userRepository.save(teacher2);

        }

        if(this.userRepository.findByEmail("third@gmail.com").isEmpty()) {

            UserEntity teacher3 = new UserEntity();
            teacher3.setFirstName("Third");
            teacher3.setFamilyName("teacher");
            teacher3.setEgn("8508675687");
            teacher3.setEmail("third@gmail.com");
            teacher3.setRoles(List.of(getRoles(2l)));
            teacher3.setPassword(this.passwordEncoder.encode("987654321"));
            this.userRepository.save(teacher3);

        }

        if(this.userRepository.findByEmail("fourth@gmail.com").isEmpty()) {

            UserEntity teacher4 = new UserEntity();
            teacher4.setFirstName("Fourth");
            teacher4.setFamilyName("teacher");
            teacher4.setEgn("7508675687");
            teacher4.setEmail("fourth@gmail.com");
            teacher4.setRoles(List.of(getRoles(2l)));
            teacher4.setPassword(this.passwordEncoder.encode("12341234"));
            this.userRepository.save(teacher4);

        }

        if(this.userRepository.findByEmail("fifth@gmail.com").isEmpty()) {

            UserEntity teacher5 = new UserEntity();
            teacher5.setFirstName("Fifth");
            teacher5.setFamilyName("teacher");
            teacher5.setEgn("9808675687");
            teacher5.setEmail("fifth@gmail.com");
            teacher5.setRoles(List.of(getRoles(2l)));
            teacher5.setPassword(this.passwordEncoder.encode("123123123"));
            this.userRepository.save(teacher5);

        }

        if(this.userRepository.findByEmail("sixth@gmail.com").isEmpty()) {

            UserEntity teacher6 = new UserEntity();
            teacher6.setFirstName("Sixth");
            teacher6.setFamilyName("teacher");
            teacher6.setEgn("7708675687");
            teacher6.setEmail("sixth@gmail.com");
            teacher6.setRoles(List.of(getRoles(2l)));
            teacher6.setPassword(this.passwordEncoder.encode("321321321"));
            this.userRepository.save(teacher6);

        }

    }

    @Override
    public void setAttendance(SetAttendanceBindingModel setAttendanceBindingModel,Long id) {
        UserEntity student = this.userRepository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException("Student with requested id=" + id + " not found.")
        );

        GradeEntity currentGrade = this.gradeRepository.findByGrade(setAttendanceBindingModel.getGrade());

        student.setGrades(
                student.addGradesToStudent(currentGrade)
        );

        this.userRepository.save(student);
    }

    private RoleEntity getRoles(Long id){
        return this.roleRepository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException("Role not found!")
        );
    }
}
