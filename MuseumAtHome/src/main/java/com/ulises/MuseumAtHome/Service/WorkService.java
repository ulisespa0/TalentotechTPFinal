package com.ulises.MuseumAtHome.Service;

import com.ulises.MuseumAtHome.entity.Work;
import com.ulises.MuseumAtHome.repository.WorkRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Service
public class WorkService {

    private WorkRepository repository;

    public WorkService(WorkRepository repository){
        this.repository = repository;
    }

   /*public Work editarObra(Long id, Work dataWork){
        Optional<Work> obra = this.repository.findById(id);
        if(obra.isEmpty()){
            System.out.println("No se encontró el producto en " + this.getClass().getName());
            return null;
        }
        return obra.get();
    }*/

    public List<Work> listWork(){
        System.out.println(this.repository.findAll());
        return this.repository.findAll();
    }

    public Work getWork(long id){
        Optional<Work> work = repository.findById(id);
        if(work.isEmpty()){
            System.out.println("Work not found");
            return null;
        }
        return work.get();
    }

    public Work saveWork(Work work){
        Work w = this.repository.save(work);
        return w;
    }

    public Work deleteWork(Long id){
        Optional<Work> obraOpt = repository.findById(id);
        if(obraOpt.isEmpty()){
            return null;
        }
        Work work = obraOpt.get();
        repository.delete(work);
        return work;
    }

    public void editNameOfWork(Long id, Work edit){
        Optional<Work> work = repository.findById(id);
        if(work.isEmpty()){
            System.out.println("Work not found");

        }
        if(edit.getName() == null || edit.getName().isBlank())
        {
            System.out.println("Invalid name");
            return;
        }
        Work w = work.get();
        w.setName(edit.getName());
        repository.save(w);
    }


}
