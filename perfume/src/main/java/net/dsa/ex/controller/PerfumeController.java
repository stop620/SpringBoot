package net.dsa.ex.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.dsa.ex.dto.PerfumeDTO;
import net.dsa.ex.repository.PerfumeRepository;
import net.dsa.ex.service.PerfumeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
public class PerfumeController {

    private final PerfumeService ps;

    @GetMapping({"", "/"})
    public String perfume() {
        return "main";
    }

    @GetMapping("result")
    public String result() {
        return "result";
    }

    @PostMapping("save")
    public String save(PerfumeDTO perfume) {

        log.debug("설문 결과: {}", perfume);

        try {
            ps.save(perfume);
            log.debug("save success");
        } catch (Exception e) {
            log.debug("save failed");
        }

        return "redirect:/";
    }
}
