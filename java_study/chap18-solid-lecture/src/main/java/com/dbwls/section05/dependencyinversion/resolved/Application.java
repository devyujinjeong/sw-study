package com.dbwls.section05.dependencyinversion.resolved;

/* NotificationService가 추상화 된 MessageSender 인터페이스에 의존하고 있으며,
* 구체적인 구현 (EmailSender, SMSSender) 클래스는 이 인터페이스를 구현하다.
* 다른 발송 방식이 추가 되어도 NotificationService 클래스의 코드는 영향 받지 않는다.*/
public class Application {
    public static void main(String[] args) {
        MessageSender smsSender = new SMSSender();
        MessageSender emailSender = new EmailSender();

        NotificationService ns1 = new NotificationService(smsSender);
        NotificationService ns2 = new NotificationService(emailSender);

        ns1.sendNotification("sms");
        ns2.sendNotification("sms");

    }
}
