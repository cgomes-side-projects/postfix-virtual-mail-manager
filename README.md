# Postfix virtual Mail Manager

Web based project to manage **virtual domains** and **virtual users** on [Postfix][0], you can also create **Aliases** and **Forwarders**.

This project is built with Java on top of Spring framework.


## Configuration

If you do not have a Postfix server up and running, you can follow [Linode's guide][1], this is very easy and useful.

This project use default tables to manage data and configure Postfix and Dovecot to use complex pre-processed views.

### domains view

`/etc/postfix/mysql-virtual-mailbox-domains.cf`

```shell
user = mailuser
password = mailuserpass
hosts = 127.0.0.1
dbname = mailserver
query = SELECT 1 FROM domains_view WHERE name='%s'
```

### users view

`/etc/postfix/mysql-virtual-mailbox-maps.cf`

```shell
user = mailuser
password = mailuserpass
hosts = 127.0.0.1
dbname = mailserver
query = SELECT 1 FROM users_view WHERE email='%s'
```


### Dovecot SQL
Dovecote needs columns names different from Postfix, so we make changes on his own sql config.

We also configure dovecot home to use ID instead user name,
this way you can change user names without lose old emails.

`/etc/dovecot/dovecot-sql.conf.ext`

```shell
driver = mysql
connect = host=127.0.0.1 dbname=postfix_db user=mailuser password=mailuserpass
default_pass_scheme = CRYPT

password_query = SELECT email as user, password FROM users_view WHERE email='%u';

user_query = SELECT email as user, password, concat('/home/vmail/%d/', id) AS home, concat('maildir:/home/vmail/%d/', id, '/Maildir') AS mail, 'yes' AS allow_all_users FROM users_view WHERE email='%u';
```




 





[0]: http://www.postfix.org/
[1]: https://www.linode.com/docs/email/postfix/email-with-postfix-dovecot-and-mysql
