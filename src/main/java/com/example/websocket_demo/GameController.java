package com.example.websocket_demo;

import com.example.websocket_demo.GameMove;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class GameController {

    private static final Logger logger = LoggerFactory.getLogger(GameController.class);

    @MessageMapping("/move")
    @SendTo("/topic/gameState")
    public GameMove processMove(GameMove move) {
        logger.info("Processing move: row = {}, column = {}", move.getRow(), move.getColumn());
        return move;
    }
}
