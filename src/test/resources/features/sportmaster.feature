#language:ru

  Функционал: спортмастер
    Сценарий: найти тент
      Пусть совершен переход на страницу "Главная страница Спормастер" по ссылке из property файла "Sportmaster"
      И элемент "Выбранный город сайта" содержит значение "Москва"
      И Навести курсор на элемент "Каталог товаров"
      И Навести курсор на меню каталога "Туризм и активный отдых"
      И Нажать курсор на меню каталога "Палатки и тенты"
      Тогда страница "Список товаров" загрузилась
      И выполнено нажатие на поле "Выбор сортировки"
      И выполнено нажатие на поле "По убыванию"
      И В фасете "Ветроустойчивость" выбрать значение "Высокая"
      И В фасете "Водонепроницаемость" выбрать значение "Высокая"
      И В фасете "Количество мест" выбрать значение "3"
      И В фасете "Тип товара" выбрать значение "Туристические"
      И выполнено нажатие на блок "Товар"
      Тогда страница "Карточка товара" загрузилась
      И Выполнено нажатие на поле "Забрать в магазине"
      Тогда Сохранить адреса магазинов "Адреса компаний"

