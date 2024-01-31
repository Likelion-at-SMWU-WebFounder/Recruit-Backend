package com.smlikelion.webfounder.global.project;

import com.smlikelion.webfounder.global.dto.response.BaseResponse;
import com.smlikelion.webfounder.global.dto.response.ErrorCode;
import com.smlikelion.webfounder.global.project.dto.ProjListResponseDto;
import com.smlikelion.webfounder.global.project.dto.ProjRequestDto;
import com.smlikelion.webfounder.global.project.dto.ProjResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/project")
public class ProjController {
    private final ProjectService projectService;

    // [POST] 프로젝트 작성
    @PostMapping()
    public BaseResponse<ProjRequestDto>  createProj(@RequestBody @Valid ProjRequestDto requestDto){
        ProjRequestDto project = projectService.createProj(requestDto);
        return new BaseResponse<>(ErrorCode.CREATED,project);
    }

    // [GET] 프로젝트 전체 조회
    @GetMapping()
    public BaseResponse<List<ProjResponseDto>> getAllProj(){
        return new BaseResponse<>(projectService.findAllProj());
    }

    // [GET] 프로젝트 상세 조회
    @GetMapping("/{id}")
    public BaseResponse<ProjListResponseDto> getOneProj(@PathVariable Long id){
        return new BaseResponse<>(projectService.findOneProj(id));
    }
}
