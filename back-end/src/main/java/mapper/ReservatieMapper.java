package mapper;

import dto.ReservatieDto;
import entity.Reservatie;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReservatieMapper {

    private final KlantDetailsMapper klantDetailsMapper;

    public ReservatieMapper(KlantDetailsMapper klantDetailsMapper) {
        this.klantDetailsMapper = klantDetailsMapper;
    }


    public ReservatieDto convertToDto(Reservatie reservatie) {
        return new ReservatieDto.Builder()
                .withDate(reservatie.getDate())
                .withId(reservatie.getId())
                .withKlantDetails(klantDetailsMapper.convertToDto(reservatie.getKlantDetails()))
                .withGekozenZalen(reservatie.getGekozenZalen())
                .withChampagneGlazen(reservatie.isChampagneGlazen())
                .withEetGerief(reservatie.isEetGerief())
                .withGasfriteuse(reservatie.isGasfriteuse())
                .withKoffiemachine(reservatie.isKoffiemachine())
                .withAantalPersonen(reservatie.getAantalPersonen())
                .withBeginuur(reservatie.getBeginuur())
                .withEinduur(reservatie.getEinduur())
                .withGekozenDranken(reservatie.getGekozenDranken())
                .withReceptieBeamer(reservatie.isReceptieBeamer())
                .build();
    }

    public Reservatie convertToEntity(ReservatieDto reservatieDto) {
        return new Reservatie.Builder()
                .withId(reservatieDto.getId())
                .withDate(reservatieDto.getDate())
                .withGekozenZalen(reservatieDto.getGekozenZalen())
                .withKlantDetails(klantDetailsMapper.convertToEntity(reservatieDto.getKlantDetails()))
                .withChampagneGlazen(reservatieDto.isChampagneGlazen())
                .withEetGerief(reservatieDto.isEetGerief())
                .withGasfriteuse(reservatieDto.isGasfriteuse())
                .withKoffiemachine(reservatieDto.isKoffiemachine())
                .withAantalPersonen(reservatieDto.getAantalPersonen())
                .withBeginuur(reservatieDto.getBeginuur())
                .withEinduur(reservatieDto.getEinduur())
                .withGekozenDranken(reservatieDto.getGekozenDranken())
                .withReceptieBeamer(reservatieDto.isReceptieBeamer())
                .build();
    }

    public List<ReservatieDto> convertListToDto(List<Reservatie> reservaties) {
        return reservaties.stream().map(this::convertToDto).collect(Collectors.toList());
    }
}
