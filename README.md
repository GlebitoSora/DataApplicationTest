# Нагрузочное тестирование
### Нагрузочное тестирование проведено с помощью Apache Jmeter
в директории DataLoadTests/... лежат *.jmx конфиг файлы, которые можно открыть в Jmeter и провести тестирование приложения. 

*1. Было добавлено 100000 новых записей в таблицу:*


### __*График времени работы запросов*__:
![Image alt](https://github.com/GlebitoSora/DataApplicationTest/raw/main/DataLoadTests/insert100kRecordsOfDataLoadTest/POST.100k.jpg)

### __*Основные данные по запросам, включая медианное, количество ошибок, максимальное время запроса, минимальное время запроса и 90-й,95-й,99-й процентиль:*__
![Image alt](https://github.com/GlebitoSora/DataApplicationTest/raw/main/DataLoadTests/insert100kRecordsOfDataLoadTest/aggregateReportFor100k.jpg)

*2. Было распределено получение 1000000 записей по рандомному id (в диапазоне от 0 до 1000000) на 100 пользователей. Предварительно были подготовлены 1000000 данных.*


### __*График времени работы запросов:*__
![Image alt](https://github.com/GlebitoSora/DataApplicationTest/raw/main/DataLoadTests/insert100kRecordsOfDataLoadTest/GET.10kperUser.png)

### __*Основные данные по запросам, включая медианное, количество ошибок, максимальное время запроса, минимальное время запроса и 90-й,95-й,99-й процентиль:*__
![Image alt](https://github.com/GlebitoSora/DataApplicationTest/raw/main/DataLoadTests/insert100kRecordsOfDataLoadTest/aggregateReportforAllGet.png)





  




