package dabang;

import dabang.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    @Autowired ReservationRepository reservationRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPaid_Reservationinfo(@Payload Paid paid){

        if(!paid.validate()) return;

        System.out.println("\n\n##### listener Reservationinfo : " + paid.toJson() + "\n\n");
        Reservation reservation = new Reservation();
        reservation.setStatus("Reservation Confirmed");
        reservation.setContractId(paid.getContractId());
        reservationRepository.save(reservation);


        // Sample Logic //
        // Reservation reservation = new Reservation();
        // reservationRepository.save(reservation);

    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverContractcanceled_Reservationcancel(@Payload Contractcanceled contractcanceled){

        if(!contractcanceled.validate()) return;

        System.out.println("\n\n##### listener Reservationcancel : " + contractcanceled.toJson() + "\n\n");

        Reservation reservation = reservationRepository.findByContractId(contractcanceled.getContractId());
        reservation.setStatus("Reservation Canceled");
        reservationRepository.save(reservation);

        // Sample Logic //
        // Reservation reservation = new Reservation();
        // reservationRepository.save(reservation);

    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}


}