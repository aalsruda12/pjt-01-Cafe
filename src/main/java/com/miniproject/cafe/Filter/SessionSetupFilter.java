package com.miniproject.cafe.Filter;

import com.miniproject.cafe.Mapper.MemberMapper;
import com.miniproject.cafe.VO.MemberVO;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@RequiredArgsConstructor
public class SessionSetupFilter extends OncePerRequestFilter {

    private final MemberMapper memberMapper;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // 1. 현재 스프링 시큐리티 상에서 인증된 사용자인지 확인
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        // 인증 정보가 있고, 익명 사용자(비로그인)가 아니라면
        if (auth != null && auth.isAuthenticated() && !(auth instanceof AnonymousAuthenticationToken)) {

            HttpSession session = request.getSession();

            // 2. 세션에 'member' 정보가 없는지 확인 (서버 재시작 후 Remember-Me로 들어온 경우)
            if (session.getAttribute("member") == null) {

                // 3. 인증 정보에서 이메일(ID) 추출
                String email = auth.getName();

                // 4. DB에서 회원 정보 다시 조회
                MemberVO member = memberMapper.findByEmail(email);

                if (member != null) {
                    // 5. 세션에 다시 저장 (마치 금방 로그인한 것처럼 복구)
                    session.setAttribute("member", member);
                }
            }
        }

        filterChain.doFilter(request, response);
    }
}