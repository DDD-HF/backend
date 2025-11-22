package com.example.dddbackend.member.infrastructure.db;

import com.example.domain.member.model.MemberId;
import com.example.domain.member.model.Proof;
import com.example.domain.member.spi.ProofRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class InMemoryProofRepository implements ProofRepository {

    private final Map<MemberId, List<Proof>> proofs;

    public InMemoryProofRepository(Map<MemberId, List<Proof>> proofs) {
        this.proofs = proofs;
    }

    @Override
    public Proof save(Proof proof) {
        List<Proof> proofList = proofs.get(proof.memberId());
        if (proofList == null) {
            proofList = new ArrayList<>();
        }
        proofList.add(proof);
        proofs.put(proof.memberId(), proofList);

        return proof;
    }

    @Override
    public List<Proof> findById(MemberId id) {
        return proofs.getOrDefault(id, List.of());
    }

    @Override
    public void delete(MemberId id) {
        proofs.remove(id);
    }
}
