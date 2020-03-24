package haui.doan.stores.business.implement;

import haui.doan.stores.business.service.MailService;
import haui.doan.stores.dto.dxo.MailDxo;
import haui.doan.stores.framework.Constants;
import haui.doan.stores.utils.DateUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailServiceImpl implements MailService {

    private final JavaMailSender sender;

    @Override
    public void sendMail(MailDxo dxo) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(dxo.getTo());
        mailMessage.setSubject(dxo.getTitle());
        mailMessage.setFrom(Constants.MAIL.FROM);
        mailMessage.setSentDate(DateUtils.now());
        mailMessage.setText(dxo.getContent());
        sender.send(mailMessage);
    }
}
