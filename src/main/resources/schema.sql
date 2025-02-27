DROP TABLE IF EXISTS tm_blog;

CREATE TABLE tm_blog (
    id INT NOT NULL AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    content MEDIUMTEXT,
    author VARCHAR(255) DEFAULT '咫',
    create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    status INT,
    PRIMARY KEY (id),
    index title_index (title),
    index author_index (author)
);
