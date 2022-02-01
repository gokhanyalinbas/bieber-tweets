```
*************************************************************
*                                                           *
*       ________  __    __  ________    ____       ______   *
*      /_/_/_/_/ /_/   /_/ /_/_/_/_/  _/_/_/_   __/_/_/_/   *
*     /_/_____  /_/___/_/    /_/    /_/___/_/  /_/          *
*    /_/_/_/_/   /_/_/_/    /_/    /_/_/_/_/  /_/           *
*   ______/_/       /_/    /_/    /_/   /_/  /_/____        *
*  /_/_/_/_/       /_/    /_/    /_/   /_/    /_/_/_/ . io  *
*                                                           *
*************************************************************
```


Bieber Tweets


# Build & Deploy #

* **with docker**

- [x] First you have to install docker  on your PC.
- [x] We have to run maven **`clean`** - **`install`** command and be sure about that you have .jar file under /target folder.
- [x] Open command promt or terminal and go to directory HOME:/twitterapp. Dockerfile is here.
- [x] To dockerize your  springboot  application run this command **`docker build -t twitterapp .`**  
- [x] After succesfull built you can run this docker image in a seperate container with this command  **`docker run --name twittercontainer -i twitterapp `**  
- [x] check docker running containers  **`docker ps`** 
- [x] check logs of  image **`docker logs twittercontainer`** 


* **without docker**
- [x] Open twitterapp folder in your spring IDE (IntellIJ,Eclipse, STS ..) or command prompt and run **`clean`** - **`install`** command.
- [x] After build you can run .jar file.

# Test #

```
Package	       Class, %	       Method, %	     Line, %
all classes	83,3% (10/ 12)	89,6% (43/ 48)	92,8% (128/ 138)
```
# Output File #

After running application you can access the tweet list file under ./out/list.json.
I save the file as a JSON file.

**Example Running**
```
C:\Users\Lenovo\IdeaProjects\twitterapp>docker build -t twitterapp .
[+] Building 13.7s (7/7) FINISHED
 => [internal] load build definition from Dockerfile                                                                                                          0.1s
 => => transferring dockerfile: 31B                                                                                                                           0.0s
 => [internal] load .dockerignore                                                                                                                             0.1s
 => => transferring context: 2B                                                                                                                               0.0s
 => [internal] load metadata for docker.io/library/openjdk:8                                                                                                 13.4s
 => [internal] load build context                                                                                                                             0.0s
 => => transferring context: 74B                                                                                                                              0.0s
 => [1/2] FROM docker.io/library/openjdk:8@sha256:92ea5796fd2e2d34aa650d3649b15915379a468cc10be8199e80e78851582da8                                            0.0s
 => CACHED [2/2] ADD target/java-exercise.jar app.jar                                                                                                         0.0s
 => exporting to image                                                                                                                                        0.1s
 => => exporting layers                                                                                                                                       0.0s
 => => writing image sha256:fdfd5c3c4557ae7a4a7c3ed137287e243bbf8700d0c2ba26cdcdf2501602f968                                                                  0.0s
 => => naming to docker.io/library/twitterapp                                                                                                                 0.0s

Use 'docker scan' to run Snyk tests against images to find vulnerabilities and learn how to fix them

C:\Users\Lenovo\IdeaProjects\twitterapp>docker run --name twittercontainer -i twitterapp

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v2.6.3)

2022-02-01 17:48:30.615  INFO 1 --- [           main] com.sytac.twitter.TwitterappApplication  : Starting TwitterappApplication v0.0.1-SNAPSHOT using Java 1.8.0_31
2 on 974cc42d387f with PID 1 (/app.jar started by root in /)
2022-02-01 17:48:30.619  INFO 1 --- [           main] com.sytac.twitter.TwitterappApplication  : No active profile set, falling back to default profiles: default
2022-02-01 17:48:32.043  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
2022-02-01 17:48:32.063  INFO 1 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2022-02-01 17:48:32.063  INFO 1 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.56]
2022-02-01 17:48:32.147  INFO 1 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2022-02-01 17:48:32.147  INFO 1 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 1448 ms
2022-02-01 17:48:32.757  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2022-02-01 17:48:32.771  INFO 1 --- [           main] com.sytac.twitter.TwitterappApplication  : Started TwitterappApplication in 2.688 seconds (JVM running for 3.
253)
2022-02-01 17:48:32.774  INFO 1 --- [           main] com.sytac.twitter.TwitterappApplication  : Application started...
2022-02-01 17:48:32.774  INFO 1 --- [           main] c.s.twitter.service.MessageServiceImpl   : Streaming started...
2022-02-01 17:48:33.803  INFO 1 --- [           main] c.s.twitter.oauth.TwitterAuthenticator   :
Go to the following link in your browser:
https://api.twitter.com/oauth/authorize?oauth_token=byL7dQAAAAAAt7ElAAABfrZnC5g

2022-02-01 17:48:33.805  INFO 1 --- [           main] c.s.twitter.oauth.TwitterAuthenticator   :
Please enter the retrieved PIN:
1666875
2022-02-01 17:48:43.110  INFO 1 --- [           main] c.s.twitter.oauth.TwitterAuthenticator   : Received Token key: 105691601-EAJEBIInjcM0mu35eDdjoF0vTrRKBlCVbvUp
hVHm secret: ozj6QmgULvpu23oR6lI37Dy36j58QOPuKn002MC7Hptar
2022-02-01 17:48:43.124  INFO 1 --- [][initializing]] twitter4j.TwitterStreamImpl              : Establishing connection.
2022-02-01 17:48:43.786  INFO 1 --- [ing connection]] twitter4j.TwitterStreamImpl              : Connection established.
2022-02-01 17:48:43.787  INFO 1 --- [ing connection]] twitter4j.TwitterStreamImpl              : Receiving status stream.
2022-02-01 17:48:43.811  INFO 1 --- [c Dispatcher[0]] c.s.twitter.service.MessageServiceImpl   : 1. Tweet : RT @Eloisa_escotoo: Ya entiendo a las fans de justin bi
eber que lloraron por unas entradas� soy ellas en este momento��
2022-02-01 17:48:47.429  INFO 1 --- [c Dispatcher[0]] c.s.twitter.service.MessageServiceImpl   : 2. Tweet : @melfarra123 So true look at bieber  buying a Bayc for
500 eth �
2022-02-01 17:48:50.903  INFO 1 --- [c Dispatcher[0]] c.s.twitter.service.MessageServiceImpl   : 3. Tweet : Hailey Bieber para WSJ Magazine Spring 2022 . https://t
.co/8kj6gWtRoE
2022-02-01 17:48:51.060  INFO 1 --- [c Dispatcher[0]] c.s.twitter.service.MessageServiceImpl   : 4. Tweet : RT @goldengateblond: one time Elizabeth Warren proposed
 making the ultra-wealthy pay 2 cents on every dollar of their net worth above $50 m…
2022-02-01 17:48:51.190  INFO 1 --- [c Dispatcher[0]] c.s.twitter.service.MessageServiceImpl   : 5. Tweet : @SomaKazima Is that Justin Bieber?
2022-02-01 17:48:51.382  INFO 1 --- [c Dispatcher[0]] c.s.twitter.service.MessageServiceImpl   : 6. Tweet : RT @popgodbieber: Justin Bieber in 2021: https://t.co/w
J0FHk43A1
2022-02-01 17:48:51.911  INFO 1 --- [c Dispatcher[0]] c.s.twitter.service.MessageServiceImpl   : 7. Tweet : RT @gkukdan_: Justin bieber sempre q fala Hailey os olh
inhos brilham. qro um relacionamento assim https://t.co/QqnLViK68e
2022-02-01 17:48:58.573  INFO 1 --- [c Dispatcher[0]] c.s.twitter.service.MessageServiceImpl   : 8. Tweet : Hailey Bieber para WSJ Magazine Spring 2022. https://t.
co/neN0fA5xha
2022-02-01 17:48:59.535  INFO 1 --- [c Dispatcher[0]] c.s.twitter.service.MessageServiceImpl   : 9. Tweet : Baby
2022-02-01 17:49:03.055  INFO 1 --- [c Dispatcher[0]] c.s.twitter.service.MessageServiceImpl   : 10. Tweet : RT @goldengateblond: one time Elizabeth Warren propose
d making the ultra-wealthy pay 2 cents on every dollar of their net worth above $50 m…
2022-02-01 17:49:04.772  INFO 1 --- [c Dispatcher[0]] c.s.twitter.service.MessageServiceImpl   : 11. Tweet : RT @ABTLABinsider: Justin Bieber x Dua Lipa
2022-02-01 17:49:07.752  INFO 1 --- [c Dispatcher[0]] c.s.twitter.service.MessageServiceImpl   : 12. Tweet : RT @ajayyii: Hypocrisy! @justinbieber HAVE A SPINE htt
ps://t.co/8LT0fMlIxh
2022-02-01 17:49:08.243  INFO 1 --- [c Dispatcher[0]] c.s.twitter.service.MessageServiceImpl   : 13. Tweet : RT @miyuki15_: Les premiers sons de Justin Bieber ont
bercé mon enfance
2022-02-01 17:49:09.379  INFO 1 --- [c Dispatcher[0]] c.s.twitter.service.MessageServiceImpl   : 14. Tweet : No��
2022-02-01 17:49:11.194  INFO 1 --- [c Dispatcher[0]] c.s.twitter.service.MessageServiceImpl   : 15. Tweet : RT @goldengateblond: one time Elizabeth Warren propose
d making the ultra-wealthy pay 2 cents on every dollar of their net worth above $50 m…
2022-02-01 17:49:11.430  INFO 1 --- [c Dispatcher[0]] c.s.twitter.service.MessageServiceImpl   : 16. Tweet : Vixe, vão entrevistar ela sobre o que agora? https://t
.co/boIvBYPqJ2
2022-02-01 17:49:15.040  INFO 1 --- [           main] c.s.twitter.service.MessageServiceImpl   : Stream shutdown:false elapsed time: 30000, tweet count: 16
2022-02-01 17:49:15.040  INFO 1 --- [           main] c.s.t.repository.MessageRepositoryImpl   : Sort by author creation date !
2022-02-01 17:49:15.041  INFO 1 --- [           main] c.s.t.repository.MessageRepositoryImpl   : Sort by message creation date !
2022-02-01 17:49:15.059  INFO 1 --- [           main] c.s.t.repository.MessageRepositoryImpl   : Write to file error ! ./out/list.json
2022-02-01 17:49:15.059  INFO 1 --- [           main] com.sytac.twitter.TwitterappApplication  : Application exit with 0.

```

**List.JSON**

```
[
  {
    "messageId": 1488569263552180224,
    "creationDate": "Feb 1, 2022 8:45:43 PM",
    "messageText": "So... do I just right click and save it to my desktop? How\u0027s this work",
    "author": {
      "userId": 1068451,
      "creationDate": "Mar 13, 2007 6:46:56 AM",
      "name": "Jay Gerland",
      "screenName": "jaygerland"
    }
  },
  {
    "messageId": 1488569195251916800,
    "creationDate": "Feb 1, 2022 8:45:27 PM",
    "messageText": "RT @goldengateblond: one time Elizabeth Warren proposed making the ultra-wealthy pay 2 cents on every dollar of their net worth above $50 m…",
    "author": {
      "userId": 19699898,
      "creationDate": "Jan 29, 2009 9:04:39 AM",
      "name": "Kiheiji - The Quiet Doom",
      "screenName": "suicidekodama"
    }
  },
  {
    "messageId": 1488569190466338824,
    "creationDate": "Feb 1, 2022 8:45:25 PM",
    "messageText": "RT @haileysoutfits: Hailey Bieber for WSJ Magazine. https://t.co/TgbpkM39Am",
    "author": {
      "userId": 218953933,
      "creationDate": "Nov 23, 2010 5:21:20 PM",
      "name": "Chiara✨",
      "screenName": "biebersjuliet"
    }
  },
  {
    "messageId": 1488569209214939141,
    "creationDate": "Feb 1, 2022 8:45:30 PM",
    "messageText": "RT @damnrightbieber: @chartdata @justinbieber Its rising!!! Omgggg deserve top 10! BUY \u0026 STREAM GHOST BY JUSTIN BIEBER https://t.co/zoXI5gF…",
    "author": {
      "userId": 376143597,
      "creationDate": "Sep 19, 2011 2:29:36 PM",
      "name": "Jesus The King. 💜",
      "screenName": "Neidebieber"
    }
  },
  {
    "messageId": 1488569284511084545,
    "creationDate": "Feb 1, 2022 8:45:48 PM",
    "messageText": "RT @ibeliebersmx: 🌎| YA ESTAMOS EN FEBRERO.\n\nLa 4ta gira mundial de Justin Bieber, \"Justice World Tour\", comienza OFICIALMENTE en este mes.…",
    "author": {
      "userId": 376143597,
      "creationDate": "Sep 19, 2011 2:29:36 PM",
      "name": "Jesus The King. 💜",
      "screenName": "Neidebieber"
    }
  },
  {
    "messageId": 1488569195197575174,
    "creationDate": "Feb 1, 2022 8:45:27 PM",
    "messageText": "TA VINDO AI",
    "author": {
      "userId": 402138911,
      "creationDate": "Oct 31, 2011 6:18:43 PM",
      "name": "kelly vai no rir",
      "screenName": "usedcabello"
    }
  },
  {
    "messageId": 1488569266999861255,
    "creationDate": "Feb 1, 2022 8:45:44 PM",
    "messageText": "RT @haileysoutfits: Hailey Bieber for WSJ Magazine. https://t.co/TgbpkM39Am",
    "author": {
      "userId": 505755393,
      "creationDate": "Feb 27, 2012 1:05:30 PM",
      "name": "𝓮𝓾",
      "screenName": "biebsftcxm"
    }
  },
  {
    "messageId": 1488569171273203720,
    "creationDate": "Feb 1, 2022 8:45:21 PM",
    "messageText": "RT @buzztinswifey: Justin Bieber is married ,Nick Jonas is married, Ariana Grande is married, Zyan Malik is a dad, Rihanna is pregnant 🧍 I…",
    "author": {
      "userId": 868232053,
      "creationDate": "Oct 8, 2012 6:59:37 PM",
      "name": "🌈",
      "screenName": "biebersico"
    }
  },
  {
    "messageId": 1488569264948846601,
    "creationDate": "Feb 1, 2022 8:45:43 PM",
    "messageText": "@nervousthought hailey bieber",
    "author": {
      "userId": 920455429,
      "creationDate": "Nov 2, 2012 7:55:32 AM",
      "name": "angel saw ari ♡ | 197",
      "screenName": "angelliczkaa"
    }
  },
  {
    "messageId": 1488569197793710082,
    "creationDate": "Feb 1, 2022 8:45:27 PM",
    "messageText": "RT @jxstinfernet: no les pasa que ✨van a ir a ver a justin bieber en septiembre ✨",
    "author": {
      "userId": 2576117007,
      "creationDate": "Jun 2, 2014 12:11:09 AM",
      "name": "💕 𝑯𝒆 𝒉𝒂𝒔 𝒈𝒓𝒆𝒆𝒏 𝒆𝒚𝒆𝒔 💕",
      "screenName": "Lopez_01_Camii"
    }
  },
  {
    "messageId": 1488569199073103879,
    "creationDate": "Feb 1, 2022 8:45:27 PM",
    "messageText": "Justin Bieber Jokingly Calls Out Charlie Puth For Dissing Him Years Ago I Billboard News https://t.co/bHob11bk1A",
    "author": {
      "userId": 880112324987822082,
      "creationDate": "Jun 28, 2017 8:15:04 PM",
      "name": "The Chestnut Post",
      "screenName": "TheChestnutPost"
    }
  },
  {
    "messageId": 1488569261232640000,
    "creationDate": "Feb 1, 2022 8:45:42 PM",
    "messageText": "Can’t wait for the ape doodle recession",
    "author": {
      "userId": 888803066509766657,
      "creationDate": "Jul 22, 2017 7:48:59 PM",
      "name": "louis deboyo",
      "screenName": "FalseCarsonMT"
    }
  },
  {
    "messageId": 1488569204672380929,
    "creationDate": "Feb 1, 2022 8:45:29 PM",
    "messageText": "RT @LoveGlowberry: — Según diferentes medios Jungkook de BTS, el actor de Bollywood Saif Ali Khan y el cantante estadounidense Justin Biebe…",
    "author": {
      "userId": 901642782082830336,
      "creationDate": "Aug 27, 2017 6:09:25 AM",
      "name": "Celeste⁷",
      "screenName": "CelestJua17"
    }
  },
  {
    "messageId": 1488569171227070467,
    "creationDate": "Feb 1, 2022 8:45:21 PM",
    "messageText": "RT @talkofthecharts: \"Ghost\" by Justin Bieber reaches a new peak of #13 on this week\u0027s Hot 100. https://t.co/AQJ2jr2W2I",
    "author": {
      "userId": 946761795435450368,
      "creationDate": "Dec 29, 2017 6:16:16 PM",
      "name": "Amity🍄(2022)",
      "screenName": "ishidaSui4"
    }
  },
  {
    "messageId": 1488569192064323585,
    "creationDate": "Feb 1, 2022 8:45:26 PM",
    "messageText": "CELEBRATE THE BIEBER BULL MARKET WITH @THEDROPNFT!\nAlso today:\n@coolcatsnft / Cool Pets\n@loveless_city x @CBCreepz collab\n@JohnnyDeppNFT \n@AzukiZen explosion\n@BoredApeYC \n@SophiaSoloo",
    "author": {
      "userId": 949458210494140416,
      "creationDate": "Jan 6, 2018 4:50:52 AM",
      "name": "VonDoom.eth",
      "screenName": "CryptoVonDoom"
    }
  },
  {
    "messageId": 1488569190348832771,
    "creationDate": "Feb 1, 2022 8:45:25 PM",
    "messageText": "RT @goldengateblond: one time Elizabeth Warren proposed making the ultra-wealthy pay 2 cents on every dollar of their net worth above $50 m…",
    "author": {
      "userId": 1061951526975954944,
      "creationDate": "Nov 12, 2018 2:59:08 PM",
      "name": "Sean Moguel",
      "screenName": "TheKid__24"
    }
  },
  {
    "messageId": 1488569192760713221,
    "creationDate": "Feb 1, 2022 8:45:26 PM",
    "messageText": "RT @rockinbieber22: Faltam 215 dias para o show do Justin Bieber no Rock In Rio 2022.",
    "author": {
      "userId": 1083567264937459714,
      "creationDate": "Jan 11, 2019 6:32:22 AM",
      "name": "aly",
      "screenName": "alyferolli"
    }
  },
  {
    "messageId": 1488569257218568195,
    "creationDate": "Feb 1, 2022 8:45:41 PM",
    "messageText": "RT @goldengateblond: one time Elizabeth Warren proposed making the ultra-wealthy pay 2 cents on every dollar of their net worth above $50 m…",
    "author": {
      "userId": 1091787096635920384,
      "creationDate": "Feb 2, 2019 10:55:03 PM",
      "name": "The Meme-Industrial Complex",
      "screenName": "MemeIndustrial"
    }
  },
  {
    "messageId": 1488569282418003968,
    "creationDate": "Feb 1, 2022 8:45:47 PM",
    "messageText": "RT @clownedbyhailey: Hailey Bieber. https://t.co/tstByAHKC7",
    "author": {
      "userId": 1254511679779467264,
      "creationDate": "Apr 26, 2020 11:44:36 PM",
      "name": "Kikii",
      "screenName": "4mystars1"
    }
  },
  {
    "messageId": 1488569258347012103,
    "creationDate": "Feb 1, 2022 8:45:42 PM",
    "messageText": "RT @khoidaooo: hey @justinbieber it’s mine now https://t.co/7G25vJKOaJ",
    "author": {
      "userId": 1255782931123101696,
      "creationDate": "Apr 30, 2020 11:56:04 AM",
      "name": "Elisabeth #XiaoHaver",
      "screenName": "07Elisabeth_"
    }
  },
  {
    "messageId": 1488569202868957189,
    "creationDate": "Feb 1, 2022 8:45:28 PM",
    "messageText": "RT @Maximilliani: Justin talking about how his feelings were hurt when Charlie Puth \"jokingly\" told him \"f*ck you\" on stage but then he did…",
    "author": {
      "userId": 1320759635826118660,
      "creationDate": "Oct 26, 2020 7:10:24 PM",
      "name": "singer/songwriter beck(tt)y",
      "screenName": "ingenueswift"
    }
  },
  {
    "messageId": 1488569275069906944,
    "creationDate": "Feb 1, 2022 8:45:46 PM",
    "messageText": "RT @CryptoVonDoom: CELEBRATE THE BIEBER BULL MARKET WITH @THEDROPNFT!\nAlso today:\n@coolcatsnft / Cool Pets\n@loveless_city x @CBCreepz colla…",
    "author": {
      "userId": 1448770009996541979,
      "creationDate": "Oct 15, 2021 12:57:59 AM",
      "name": "notzahwanshiyaz",
      "screenName": "TheChosenGooose"
    }
  },
  {
    "messageId": 1488569177837293585,
    "creationDate": "Feb 1, 2022 8:45:22 PM",
    "messageText": "RT @mylestanzer: genius @laneflorsheim with her first cover story (!) talking to hailey bieber who says: \"The media has always been a disgu…",
    "author": {
      "userId": 1462158586323226626,
      "creationDate": "Nov 20, 2021 11:40:21 PM",
      "name": "JbV",
      "screenName": "JbVL0"
    }
  },
  {
    "messageId": 1488569217540632577,
    "creationDate": "Feb 1, 2022 8:45:32 PM",
    "messageText": "RT @WSJMag: This year, Hailey Bieber is launching a skin-care brand, Rhode, for those who want “glazed donut” skin like hers. “The whole et…",
    "author": {
      "userId": 1462158586323226626,
      "creationDate": "Nov 20, 2021 11:40:21 PM",
      "name": "JbV",
      "screenName": "JbVL0"
    }
  },
  {
    "messageId": 1488569191712145412,
    "creationDate": "Feb 1, 2022 8:45:26 PM",
    "messageText": "RT @__N0SFERATU__: Time to bring this old ass gif back https://t.co/CIiOfzbiSS",
    "author": {
      "userId": 1464281988622581760,
      "creationDate": "Nov 26, 2021 8:16:59 PM",
      "name": "rem !",
      "screenName": "stankowanks"
    }
  }
]
```


# Sytac Java Exercise #

This development test is used as part of Sytac selection for Java developers. You are requested to develop a simple application that covers all the requirements listed below. To have an indication of the criteria that will be used to judge your submission, all the following are considered as metrics of good development:

+ Correctness of the implementation
+ Decent test coverage
+ Code cleanliness
+ Efficiency of the solution
+ Careful choice of tools and data formats
+ Use of production-ready approaches

While no specific time limit is mandated to complete the exercise, you will be asked to provide your code within a given deadline from Sytac HR. You are free to choose any library as long as it can run on the JVM.

## Task ##

We would like you to write code that will cover the functionality explained below and provide us with the source, instructions to build and run the application, as well as a sample output of an execution:

+ Connect to [Twitter Streaming API 1.1](https://developer.twitter.com/en/docs/twitter-api/v1/tweets/filter-realtime/overview)
    * Use the following values:
        + Consumer Key: `RLSrphihyR4G2UxvA0XBkLAdl`
        + Consumer Secret: `FTz2KcP1y3pcLw0XXMX5Jy3GTobqUweITIFy4QefullmpPnKm4`
    * The app name will be `java-exercise`
    * You will need to login with Twitter
+ Filter messages that track on "bieber"
+ Retrieve the incoming messages for 30 seconds or up to 100 messages, whichever comes first
+ Your application should return the messages grouped by user (users sorted chronologically, ascending)
+ The messages per user should also be sorted chronologically, ascending
+ For each message, we will need the following:
    * The message ID
    * The creation date of the message as epoch value
    * The text of the message
    * The author of the message
+ For each author, we will need the following:
    * The user ID
    * The creation date of the user as epoch value
    * The name of the user
    * The screen name of the user
+ All the above information is provided in either Standard output, or a log file
+ You are free to choose the output format, provided that it makes it easy to parse and process by a machine

### __Bonus points for:__ ###

+ Keep track of messages per second statistics across multiple runs of the application
+ The application can run as a Docker container

## Provided functionality ##

The present project in itself is a [Maven project](http://maven.apache.org/) that contains one class that provides you with a `com.google.api.client.http.HttpRequestFactory` that is authorised to execute calls to the Twitter API in the scope of a specific user.
You will need to provide your _Consumer Key_ and _Consumer Secret_ and follow through the OAuth process (get temporary token, retrieve access URL, authorise application, enter PIN for authenticated token).
With the resulting factory you are able to generate and execute all necessary requests.
If you want to, you can also disregard the provided classes or Maven configuration and create your own application from scratch.

## Delivery ##

You are assigned to you own private repository. Please use your own branch and do not commit on master.
When the assignment is finished, please create a pull request on the master of this repository, and your contact person will be notified automatically. 
