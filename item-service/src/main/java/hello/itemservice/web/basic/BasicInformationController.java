package hello.itemservice.web.basic;

import hello.itemservice.domain.information.InformationDTO;
import hello.itemservice.domain.information.InformationRepository;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/basic/infos")
@RequiredArgsConstructor //생성자를 알아서 생성한다.
public class BasicInformationController {

    private final InformationRepository informationRepository;

    //infos(폼이동)
    @GetMapping
    public String infos(Model model) {
        List<InformationDTO> infos = informationRepository.findAll();
        model.addAttribute("infos", infos);
        return "basic/infos";
    }

    //addUserForm(폼이동)
    @GetMapping("/add")
    public String addUserForm() {
        return "basic/addUserForm";
    }

    //addUserFormAction
    @PostMapping("/add")
    public String addUser(@RequestParam("name") String name,
                          @RequestParam("introduce") String introduce,
                          @RequestParam("nameNumber") String nameNumber, Model model) {

        // 새로운 사용자 데이터를 InformationDTO 객체로 생성하고 저장
        InformationDTO newInfo = new InformationDTO(name, introduce, Integer.parseInt(nameNumber));
        informationRepository.save(newInfo);

        // 저장한 새로운 데이터를 합쳐서 다시 화면에 보여주기
        List<InformationDTO> infos = informationRepository.findAll();
        model.addAttribute("infos", infos);

        return "basic/infos"; // 등록 후 회원 목록 페이지로 리다이렉트
    }

    @PostConstruct
    public void init()  {
        informationRepository.save((new InformationDTO("test1", "test1", 1)));
        informationRepository.save((new InformationDTO("test2", "test2", 2)));
    }
}
