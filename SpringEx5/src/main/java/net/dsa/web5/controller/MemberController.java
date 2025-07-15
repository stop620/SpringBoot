package net.dsa.web5.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.dsa.web5.dto.MemberDTO;
import net.dsa.web5.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
@RequestMapping("member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService ms;


    /**
     * 회원가입 페이지
     * @return joinForm.html
     */
    @GetMapping("join")
    public String joinForm() {
        return "member/joinForm";
    }

    /**
     * 회원가입 처리
     * @param MemberDTO
     * @return home.html
     */
    @PostMapping("join")
    public String join(MemberDTO member) {

        log.debug("member: {}", member);

        try {
            ms.join(member);
            log.debug("join success");
        } catch (Exception e) {
            log.debug("join failed");
        }

        return "redirect:/";
    }

    /**
     * 새창으로 검색 페이지 이동
     * @return idCheck.html
     */
    @GetMapping("idCheck")
    public String idCheck() {
        return "member/idCheck";
    }

    /**
     * ID 중복확인 페이지에서 검색 요청 처리
     * @Param searchId 검색할 아이디
     * @return idCheck.html
     */
    @PostMapping("idCheck")
    public String idCheck(@RequestParam("searchId") String searchId,
                          Model model) {

        log.debug("searchId: ", searchId);

        // 검색할 아이디를 서비스에서 사용 가능한지 조회(true 가능 false 불가)
        boolean result = ms.idCheck(searchId);
        model.addAttribute("searchId", searchId);
        model.addAttribute("result", result);

        return "member/idCheck";
    }

    /**
     * 로그인 페이지
     * @return loginForm.html
     */
    @GetMapping("loginForm")
    public String loginForm() {
        return "member/loginForm";
    }
}
