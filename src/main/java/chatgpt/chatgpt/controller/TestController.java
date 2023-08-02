package chatgpt.chatgpt.controller;

import chatgpt.chatgpt.Entity.DatePlace;
import chatgpt.chatgpt.service.DatePlaceService;
import io.github.flashvayne.chatgpt.service.ChatgptService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/chat-gpt")
public class TestController {
    private final ChatgptService chatgptService;
    private final ChatService chatService;
    private final DatePlaceService datePlaceService;
    //chat-gpt 와 간단한 채팅 서비스 소스
//    @PostMapping("")
//    public String test(@RequestBody String question){
//        System.out.println("TestController.test");
//       return chatService.getChatResponse(question);
//
//    }
    @PostMapping("")
    public String chat(@RequestBody String question) {
        System.out.println("TestController.chat");
        String keyword = extractKeywordFromInput(question);

        List<DatePlace> datePlaceRecommendation = datePlaceService.findDatePlacesByKeyword(keyword);
        String combinedInput = combineUserOpinionAndCrawledData(datePlaceRecommendation.toString());
        String gptResponse = chatService.getChatResponse(combinedInput);

        return gptResponse;
    }


    private String extractKeywordFromInput(String input) {
        String[] words = input.split("\\s+");
        if (words.length > 0) {
            return words[0];
        }
        return "";
    }
    private String combineUserOpinionAndCrawledData(String userOpinion) {
        return "이 데이트 코스 어떻게 생각해? " + userOpinion;
    }
}
