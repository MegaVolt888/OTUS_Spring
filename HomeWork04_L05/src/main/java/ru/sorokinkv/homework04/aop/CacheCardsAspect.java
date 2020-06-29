package ru.sorokinkv.homework04.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class CacheCardsAspect {
    private static final Logger log = LoggerFactory.getLogger(CacheCardsAspect.class);
    private Object cached;

    @Around("execution(public * ru.sorokinkv.homework04.dao.QuestionDao.getAllQuestions())")
    public Object cacheQuestionsCards(ProceedingJoinPoint joinPoint) throws Throwable {
        if (cached == null) {
            cached = joinPoint.proceed();
            log.debug("Questions cached");
        }
        return cached;
    }

    @Around("execution(public * ru.sorokinkv.homework04.dao.AnswerDao.getAllAnswers())")
    public Object cacheAnswersCards(ProceedingJoinPoint joinPoint) throws Throwable {
        if (cached == null) {
            cached = joinPoint.proceed();
            log.debug("Answers cached");
        }
        return cached;
    }
}
