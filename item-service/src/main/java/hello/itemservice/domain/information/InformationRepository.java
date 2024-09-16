package hello.itemservice.domain.information;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class InformationRepository {
    // static
    private static final Map<Long, InformationDTO> info = new HashMap<>();
    private static long sequence = 0L;

    // id값 자동 생성 및 계속 ++
    public InformationDTO save(InformationDTO informationDTO) {
        informationDTO.setId(++sequence);
        info.put(informationDTO.getId(), informationDTO);
        return informationDTO;
    }

    // id만 반환
    public InformationDTO findById(Long id) {
        return info.get(id);
    }

    // 모든정보 반환
    public List<InformationDTO> findAll() {
        return new ArrayList<>(info.values());
    }

    // 정보 업데이트
    public void update(Long informationId, UpdateInfoParamDTO updateInfoParamDTO) {
        InformationDTO findInformationRepository = findById(informationId);
        findInformationRepository.setName(updateInfoParamDTO.getName());
        findInformationRepository.setIntroduce(updateInfoParamDTO.getIntroduce());
        findInformationRepository.setNameNumber(updateInfoParamDTO.getNameNumber());
    }

    // 정보 초기화
    public void clearInfo() {
        info.clear();
    }
}
