package dabang;

import dabang.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class InfomationViewHandler {


    @Autowired
    private InfomationRepository infomationRepository;

    // @StreamListener(KafkaProcessor.INPUT)
    // public void whenContracted_then_CREATE_1 (@Payload Contracted contracted) {
    //     try {

    //         if (!contracted.validate()) return;

    //         // view 객체 생성
    //         Infomation infomation = new Infomation();
    //         // view 객체에 이벤트의 Value 를 set 함
    //         infomation.setContractId(contracted.getContractId());
    //         infomation.setContractstatus(contracted.getStatus());
    //         // view 레파지 토리에 save
    //         infomationRepository.save(infomation);

    //     }catch (Exception e){
    //         e.printStackTrace();
    //     }
    // }


    // @StreamListener(KafkaProcessor.INPUT)
    // public void whenPaid_then_UPDATE_1(@Payload Paid paid) {
    //     try {
    //         if (!paid.validate()) return;
    //             // view 객체 조회

    //                 List<Infomation> infomationList = infomationRepository.findByContractId(paid.getContractId());
    //                 if(infomationList.size() == 0){
    //                     Infomation infomation = new Infomation();
    //                     infomation.setContractId(paid.getContractId());
    //                     infomation.setContractstatus(paid.getStatus());
    //                     infomationRepository.save(infomation);
    //                 }
                    
    //                 for(Infomation infomation : infomationList){
    //                 // view 객체에 이벤트의 eventDirectValue 를 set 함
    //                 infomation.setPaystatus(paid.getStatus());
    //             // view 레파지 토리에 save
    //             infomationRepository.save(infomation);
    //             }

    //     }catch (Exception e){
    //         e.printStackTrace();
    //     }
    // }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenContracted_then_CREATE_1 (@Payload Paid paid) {
        try {

            if (!paid.validate()) return;
            List<Infomation> infomationList = infomationRepository.findByContractId(paid.getContractId());
            
            if(infomationList.size() > 0){
                for(Infomation infomation : infomationList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    infomation.setPaystatus(paid.getStatus());
                    // view 레파지 토리에 save
                    infomationRepository.save(infomation);
                }
            }
            else{
                // view 객체 생성
            Infomation infomation = new Infomation();
            // view 객체에 이벤트의 Value 를 set 함
            infomation.setContractId(paid.getContractId());
            infomation.setPaystatus(paid.getStatus());
            // view 레파지 토리에 save
            infomationRepository.save(infomation);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenPaid_then_UPDATE_1(@Payload Contracted contracted) {
        try {
            if (!contracted.validate()) return;
                // view 객체 조회

                    List<Infomation> infomationList = infomationRepository.findByContractId(contracted.getContractId());
                    if(infomationList.size() == 0){
                        Infomation infomation = new Infomation();
                        infomation.setContractId(contracted.getContractId());
                        infomation.setContractstatus(contracted.getStatus());
                        infomationRepository.save(infomation);
                    }
                    
                    for(Infomation infomation : infomationList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    infomation.setContractstatus(contracted.getStatus());
                // view 레파지 토리에 save
                infomationRepository.save(infomation);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenPaymentCanceled_then_UPDATE_2(@Payload PaymentCanceled paymentCanceled) {
        try {
            if (!paymentCanceled.validate()) return;
                // view 객체 조회

                    List<Infomation> infomationList = infomationRepository.findByContractId(paymentCanceled.getContractId());
                    for(Infomation infomation : infomationList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    infomation.setPaystatus(paymentCanceled.getStatus());
                // view 레파지 토리에 save
                infomationRepository.save(infomation);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenReserved_then_UPDATE_3(@Payload Reserved reserved) {
        try {
            if (!reserved.validate()) return;
                // view 객체 조회

                    List<Infomation> infomationList = infomationRepository.findByContractId(reserved.getContractId());
                    for(Infomation infomation : infomationList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    infomation.setReservationstatus(reserved.getStatus());
                // view 레파지 토리에 save
                infomationRepository.save(infomation);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenReservationCanceld_then_UPDATE_4(@Payload ReservationCanceld reservationCanceld) {
        try {
            if (!reservationCanceld.validate()) return;
                // view 객체 조회

                    List<Infomation> infomationList = infomationRepository.findByContractId(reservationCanceld.getContractId());
                    for(Infomation infomation : infomationList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    infomation.setReservationstatus(reservationCanceld.getStatus());
                // view 레파지 토리에 save
                infomationRepository.save(infomation);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenContractcanceled_then_UPDATE_5(@Payload Contractcanceled contractcanceled) {
        try {
            if (!contractcanceled.validate()) return;
                // view 객체 조회

                    List<Infomation> infomationList = infomationRepository.findByContractId(contractcanceled.getContractId());
                    for(Infomation infomation : infomationList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    infomation.setContractstatus(contractcanceled.getStatus());
                // view 레파지 토리에 save
                infomationRepository.save(infomation);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

