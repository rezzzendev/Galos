package github.rezzzedev.CRUD.Galo.service;

import github.rezzzedev.CRUD.Galo.model.Carteira;
import github.rezzzedev.CRUD.Galo.repository.CarteiraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarteiraService {

    @Autowired
    CarteiraRepository carteiraRepository;

    public Carteira salvarCarteira (Carteira carteira)
    {
        return carteiraRepository.save(carteira);
    }

}
