#language:ru

  Функционал: поиск минимальной температуры
    Сценарий: найти минимальную темперабуту в Барселоне
      Пусть совершен переход на страницу "Cтраница проосмотра погоды" по ссылке из property файла "yandexPogoda"
      И страница "Cтраница проосмотра погоды" загрузилась
      Тогда выполнено ожидание в течение 1 секунд
      Когда в поле "Поиск Города" введено значение "Барселона, Каталония, Испания"
      Тогда выполнено ожидание в течение 1 секунд
      Тогда выполнено нажатие на клавиатуре "Enter"
      Тогда выполнено ожидание в течение 3 секунд
      Когда страница "Cтраница проосмотра погоды" загрузилась
      Тогда выполнено нажатие на кнопку "Кнопка прогноз на месяц"
      Тогда выполнено ожидание в течение 3 секунд
      И страница "Просмотр температуры за месяц" загрузилась
      Если поле "Активный город" содержит значение "Барселоне"
      Тогда выполнено нажатие на что то с текстом "Май"
      Тогда выполнено ожидание в течение 3 секунд
      Когда страница "Просмотр температуры за месяц" загрузилась
      #Тогда элементы списка "температурные показатели" содержат текст "+20"
      Тогда вывести минимальное значение из списка "температурные показатели"
      Тогда выполнено ожидание в течение 3 секунд

