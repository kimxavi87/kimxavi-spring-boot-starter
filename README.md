# kimxavi-spring-boot-starter
기선님 Spring boot 강의 듣고 Auto Configure 만들어 보는 실습


* 자동설정

@ComponentScan
@Component 라고 되어있는 것들 빈으로 등록
@Service @Repository @Configuration @Controller @RestController



@EnableAutoConfiguration
스프링 메타데이터, auto-configure
spring.factories 타고 들어가면
@Configuration 이다.
ConditionalOn 들이 많다 => 조건을 충족하면 이 설정을 사용하라

springApplication.setWebApplicationType(WebApplicationType.NONE);
// web 끈다

* 자동설정 만들기

Xxx-Spring-Boot-Starter

디펜던시에
auto configurer
auto configuration processor 추가

디펜던시 매니지먼트를 통해 의존성 관리 추가

1. Configuration 만들기
    1. Bean 안에 등록
2. src/main/resource/META-INF 에 spring.factories 만들기
    1. service provider
    2. org.springframework.boot.autoconfigure.EnableAutoConfiguration=
3. mvn install


ComponentScan -> EnableAutoConfiguration 으로
등록 순서기 떄문에 덮어쓰기가 될 수 있다

@ConditionalMissingBean
=> 등록되어 있는 빈이 없으면 설정해라

* 자동설정에 프로퍼티 적용하기

spring-boot-configuration-processor 디펜던시 추가하기

@ConfigurationProperties(“NAME”)
class..

만들어서 설정할 것들 정의하기


이전에 정의해놨던 Configurationd 에
@EnableConfigurationProperties(XxxxxProperties.class)

@Bean
public… (XxxxProperties properteis) // 주입받는다
