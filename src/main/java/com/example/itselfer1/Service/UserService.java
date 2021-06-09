package com.example.itselfer1.Service;

import com.example.itselfer1.Repository.UserRepository;
import com.example.itselfer1.domain.entity.UserEntity;
import com.example.itselfer1.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.Random;

@Service
@Slf4j
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public Long savePost(UserDto userDto) {
        userDto.setFUse("0");
        userDto.setFGrade("1");

        String sMembershopNo = getRandomPassword(5, 2) + randomAlphaWord(3);
        log.debug("sMembershopNo : {}", sMembershopNo);
        userDto.setVMembershipNo(sMembershopNo);

        // 회원 진입경로
        userDto.setFJoinChannel("WEB");

        /* 휴가 승인상태
        * 1000 : 등록 (승인 전)
        * 2000 : 승인완료
        * */
        userDto.setVApproveStatus("1000");

        if (userDto.getVPhone() == null) {
            // 기존회원
            userDto.setVRemainDate("15");
        }

        userDto.setVCreateId("admin");

        return userRepository.save(userDto.toEntity()).getIdx();
    }

    @Transactional
    public Long updatePost(UserDto userDto) {
        Optional<UserEntity> userEntity = userRepository.findById(userDto.getIdx());

        userEntity.ifPresent(selectUser ->{
            System.out.println(selectUser.getVName());
            System.out.println(selectUser.getVMembershipNo());
            System.out.println(selectUser.getVRemainDate());
        });

        return userRepository.save(userDto.toEntity()).getIdx();
    }

    public static String getRandomPassword(int len, int dupCd) {

        Random rand = new Random();
        String numStr = ""; //난수가 저장될 변수

        for (int i = 0; i < len; i++) {

            //0~9 까지 난수 생성
            String ran = Integer.toString(rand.nextInt(10));

            if (dupCd == 1) {
                //중복 허용시 numStr에 append
                numStr += ran;
            } else if (dupCd == 2) {
                //중복을 허용하지 않을시 중복된 값이 있는지 검사한다
                if (!numStr.contains(ran)) {
                    //중복된 값이 없으면 numStr에 append
                    numStr += ran;
                } else {
                    //생성된 난수가 중복되면 루틴을 다시 실행한다
                    i -= 1;
                }
            }
        }
        return numStr;
    }

    public static String randomAlphaWord(int wordLength) {

        Random r = new Random();
        StringBuilder sb = new StringBuilder(wordLength);

        for(int i = 0; i < wordLength; i++) {
            char tmp = (char) ('A' + r.nextInt('Z' - 'A'));
            sb.append(tmp);
        }

        return sb.toString();
    }

}
