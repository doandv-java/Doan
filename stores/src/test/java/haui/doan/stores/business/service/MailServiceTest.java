package haui.doan.stores.business.service;

import haui.doan.stores.dto.dxo.MailDxo;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MailServiceTest {

    @Mock
    private MailService mailService;

    @Test
    void TestMail() {
        MailDxo dxo = new MailDxo();
        dxo.setContent("Test");
        dxo.setTitle("Test");
        dxo.setTo("dichthuyhan188@gmail.com");
        mailService.sendMail(dxo);
    }
}
