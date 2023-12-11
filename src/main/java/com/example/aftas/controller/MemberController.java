package com.example.aftas.controller;

import com.example.aftas.controller.vm.MemberRequestVM;
import com.example.aftas.controller.vm.MemberResponseVM;
import com.example.aftas.entities.Member;
import com.example.aftas.handler.response.ResponseMessage;
import com.example.aftas.service.interfaces.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/members")
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public ResponseEntity createMember(@RequestBody @Valid MemberRequestVM memberRequestVM){
        Member member = memberService.createMember(memberRequestVM.toMember());
        return ResponseMessage.created(
                MemberResponseVM.fromMember(member),
                "Member created successfully!");
    }
}
