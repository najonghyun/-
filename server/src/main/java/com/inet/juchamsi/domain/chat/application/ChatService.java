package com.inet.juchamsi.domain.chat.application;

import com.inet.juchamsi.domain.chat.dto.request.ChatRoomRequest;
import com.inet.juchamsi.domain.chat.dto.request.SystemChatRoomRequest;
import com.inet.juchamsi.domain.chat.dto.response.ChatRoomResponse;
import com.inet.juchamsi.domain.chat.entity.Type;

import java.util.List;

public interface ChatService {

    public List<ChatRoomResponse> showChatRoom(String loginId);

    public ChatRoomResponse showDetailChatRoom(String roomId);

    /* 사용자끼리 대화방 */
    public ChatRoomResponse createRoom(ChatRoomRequest request);

    /* 시스템 대화방 */
    public ChatRoomResponse createSystemRoom(SystemChatRoomRequest request);
}
