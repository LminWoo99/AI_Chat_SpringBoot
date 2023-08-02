package chatgpt.chatgpt.service;

import chatgpt.chatgpt.Entity.DatePlace;
import chatgpt.chatgpt.repository.DatePlaceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class DatePlaceService {
    private final DatePlaceRepository datePlaceRepository;
    public void saveData(DatePlace datePlace) {
        datePlaceRepository.save(datePlace);
    }

    public List<DatePlace> getAllData() {
        List<DatePlace> dataList = datePlaceRepository.findAll();
        return dataList;
    }
    public List<DatePlace> findDatePlacesByKeyword(String keyword) {
        List<DatePlace> places = datePlaceRepository.findByKeywordContaining(keyword);
        return places;
    }

}
