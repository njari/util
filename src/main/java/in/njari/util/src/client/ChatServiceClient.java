package in.njari.util.src.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@FeignClient(name = "chat-service", url = "${server.chatservice.url}")
@Service
public interface ChatServiceClient {

    @PostMapping("/email/send")
    void sendEmail(@RequestBody Map<String, String> sendEmailMap);
}

