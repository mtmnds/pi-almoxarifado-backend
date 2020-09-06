package br.fatec.app.modules.v1.saldo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SaldoService {

    private SaldoRepository saldoRepository;


    @Autowired
    public SaldoService(
            SaldoRepository saldoRepository
    ) {
        this.saldoRepository = saldoRepository;
    }

}
