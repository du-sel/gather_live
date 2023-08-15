SHOW TABLES;

SELECT * FROM like_profile;

SELECT * FROM member;

SELECT * FROM member_inst;
SELECT * FROM member_loca;

SELECT * FROM recruit;

DESC member;
DESC member_inst;

ALTER TABLE member_inst DROP PRIMARY KEY;
ALTER TABLE member_inst ADD CONSTRAINT PRIMARY KEY(member_id, inst_name);

alter table member_inst drop PRIMARY key, add index(member_id);

ALTER TABLE member_inst
	MODIFY COLUMN inst_name VARCHAR(50) NOT NULL;
	
DROP TABLE member_inst;

CREATE TABLE member_inst (
	member_id INT NOT NULL,
	inst_name VARCHAR(50) NOT NULL,
	inst_level VARCHAR(20) NOT NULL,
	inst_time DATE NOT NULL,
	
	foreign key(member_id) references member(member_id)
);


CREATE TABLE `final_inst` (
  `g1` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL
)

INSERT INTO `final_inst` VALUES ('嫄대컲','�뵾�븘�끂'),('嫄대컲','�떊�뵒�궗�씠��'),('嫄대컲','硫쒕줈�뵒�뼵'),('嫄대컲','�삤瑜닿컙'),('�뒪�듃留�','諛붿씠�삱由�'),('�뒪�듃留�','鍮꾩삱�씪'),('�뒪�듃留�','泥쇰줈'),('�뒪�듃留�','肄섑듃�씪踰좎씠�뒪'),('紐⑷��븙湲�','�겢�씪由щ꽬'),('紐⑷��븙湲�','�뵆猷�'),('紐⑷��븙湲�','諛붿닚'),('紐⑷��븙湲�','�삤蹂댁뿉'),('紐⑷��븙湲�','�깋�냼�룿'),('湲덇��븙湲�','�듃�읆�렖'),('湲덇��븙湲�','�듃�읆蹂�'),('湲덇��븙湲�','�샇瑜�'),('湲덇��븙湲�','�뒠諛�'),('湲고�/踰좎씠�뒪','�뼱荑좎뒪�떛 湲고�'),('湲고�/踰좎씠�뒪','�겢�옒�떇 湲고�'),('湲고�/踰좎씠�뒪','�씪�젆 湲고�'),('湲고�/踰좎씠�뒪','�씪�젆 踰좎씠�뒪'),('�뱶�읆/�띁而ㅼ뀡','�뱶�읆'),('�뱶�읆/�띁而ㅼ뀡','�띁而ㅼ뀡 �뀑'),('�뱶�읆/�띁而ㅼ뀡','�젹踰�'),('�뱶�읆/�띁而ㅼ뀡','源뚰샎'),('�뱶�읆/�띁而ㅼ뀡','遊됯퀬'),('�뱶�읆/�띁而ㅼ뀡','���뙆�땲'),('�뱶�읆/�띁而ㅼ뀡','�꺃踰꾨┛'),('�뱶�읆/�띁而ㅼ뀡','罹먯뒪�꽣�꽬痢�'),('紐⑷��븙湲�','由ъ퐫�뜑'),('援��븙湲�','嫄곕Ц怨�'),('援��븙湲�','媛��빞湲�'),('援��븙湲�','�빐湲�'),('援��븙湲�','��湲�'),('援��븙湲�','�냼湲�'),('援��븙湲�','�떒�냼'),('援��븙湲�','�깭�룊�냼'),('援��븙湲�','�냼怨�'),('援��븙湲�','遺�'),('援��븙湲�','�옣援�'),('援��븙湲�','苑밴낵由�'),('援��븙湲�','吏�'),('蹂댁뺄','�뙘 蹂댁뺄'),('蹂댁뺄','�꽦�븙 蹂댁뺄'),('蹂댁뺄','援��븙 蹂댁뺄'),('洹� �쇅','�븘肄붾뵒�뼵'),('洹� �쇅','�븯紐⑤땲移�'),('洹� �쇅','�슦荑⑤젏�젅'),('洹� �쇅','�븯�봽');

SELECT * FROM final_inst;
SELECT DISTINCT g1 FROM final_inst;


SHOW TABLES;
SELECT * FROM member_join_inst;

DESC member_loca;

DROP TABLE member_loca;
CREATE TABLE member_loca (
	member_id INT NOT NULL,
	g1 VARCHAR(50) NOT NULL,
	g2 VARCHAR(50) NOT NULL,
	g3 VARCHAR(50),	
	
	foreign key(member_id) references member(member_id)
);


CREATE TABLE final_loca (
	g1 VARCHAR(50),
	g2 VARCHAR(50),
	g3 VARCHAR(50)
);

DROP TABLE final_loca;

SELECT * FROM final_loca;


INSERT INTO final_loca VALUES ('�꽌�슱�듅蹂꾩떆', '醫낅줈援�', null);
INSERT INTO final_loca VALUES ('�꽌�슱�듅蹂꾩떆', '以묎뎄', null);
INSERT INTO final_loca VALUES ('�꽌�슱�듅蹂꾩떆', '�슜�궛援�', null);
INSERT INTO final_loca VALUES ('�꽌�슱�듅蹂꾩떆', '�꽦�룞援�', null);
INSERT INTO final_loca VALUES ('�꽌�슱�듅蹂꾩떆', '愿묒쭊援�', null);
INSERT INTO final_loca VALUES ('�꽌�슱�듅蹂꾩떆', '�룞��臾멸뎄', null);
INSERT INTO final_loca VALUES ('�꽌�슱�듅蹂꾩떆', '以묐옉援�', null);
INSERT INTO final_loca VALUES ('�꽌�슱�듅蹂꾩떆', '�꽦遺곴뎄', null);
INSERT INTO final_loca VALUES ('�꽌�슱�듅蹂꾩떆', '媛뺣턿援�', null);
INSERT INTO final_loca VALUES ('�꽌�슱�듅蹂꾩떆', '�룄遊됯뎄', null);
INSERT INTO final_loca VALUES ('�꽌�슱�듅蹂꾩떆', '�끂�썝援�', null);
INSERT INTO final_loca VALUES ('�꽌�슱�듅蹂꾩떆', '���룊援�', null);
INSERT INTO final_loca VALUES ('�꽌�슱�듅蹂꾩떆', '�꽌��臾멸뎄', null);
INSERT INTO final_loca VALUES ('�꽌�슱�듅蹂꾩떆', '留덊룷援�', null);
INSERT INTO final_loca VALUES ('�꽌�슱�듅蹂꾩떆', '�뼇泥쒓뎄', null);
INSERT INTO final_loca VALUES ('�꽌�슱�듅蹂꾩떆', '媛뺤꽌援�', null);
INSERT INTO final_loca VALUES ('�꽌�슱�듅蹂꾩떆', '援щ줈援�', null);
INSERT INTO final_loca VALUES ('�꽌�슱�듅蹂꾩떆', '湲덉쿇援�', null);
INSERT INTO final_loca VALUES ('�꽌�슱�듅蹂꾩떆', '�쁺�벑�룷援�', null);
INSERT INTO final_loca VALUES ('�꽌�슱�듅蹂꾩떆', '�룞�옉援�', null);
INSERT INTO final_loca VALUES ('�꽌�슱�듅蹂꾩떆', '愿��븙援�', null);
INSERT INTO final_loca VALUES ('�꽌�슱�듅蹂꾩떆', '�꽌珥덇뎄', null);
INSERT INTO final_loca VALUES ('�꽌�슱�듅蹂꾩떆', '媛뺣궓援�', null);
INSERT INTO final_loca VALUES ('�꽌�슱�듅蹂꾩떆', '�넚�뙆援�', null);
INSERT INTO final_loca VALUES ('�꽌�슱�듅蹂꾩떆', '媛뺣룞援�', null);
INSERT INTO final_loca VALUES ('�꽌�슱�듅蹂꾩떆', '�쟾泥�', null);


INSERT INTO final_loca VALUES ('遺��궛愿묒뿭�떆', '以묎뎄', null);
INSERT INTO final_loca VALUES ('遺��궛愿묒뿭�떆', '�꽌援�', null);
INSERT INTO final_loca VALUES ('遺��궛愿묒뿭�떆', '�룞援�', null);
INSERT INTO final_loca VALUES ('遺��궛愿묒뿭�떆', '�쁺�룄援�', null);
INSERT INTO final_loca VALUES ('遺��궛愿묒뿭�떆', '遺��궛吏꾧뎄', null);
INSERT INTO final_loca VALUES ('遺��궛愿묒뿭�떆', '�룞�옒援�', null);
INSERT INTO final_loca VALUES ('遺��궛愿묒뿭�떆', '�궓援�', null);
INSERT INTO final_loca VALUES ('遺��궛愿묒뿭�떆', '遺곴뎄', null);
INSERT INTO final_loca VALUES ('遺��궛愿묒뿭�떆', '媛뺤꽌援�', null);
INSERT INTO final_loca VALUES ('遺��궛愿묒뿭�떆', '�빐�슫��援�', null);
INSERT INTO final_loca VALUES ('遺��궛愿묒뿭�떆', '�궗�븯援�', null);
INSERT INTO final_loca VALUES ('遺��궛愿묒뿭�떆', '湲덉젙援�', null);
INSERT INTO final_loca VALUES ('遺��궛愿묒뿭�떆', '�뿰�젣援�', null);
INSERT INTO final_loca VALUES ('遺��궛愿묒뿭�떆', '�닔�쁺援�', null);
INSERT INTO final_loca VALUES ('遺��궛愿묒뿭�떆', '�궗�긽援�', null);
INSERT INTO final_loca VALUES ('遺��궛愿묒뿭�떆', '湲곗옣援�', null);
INSERT INTO final_loca VALUES ('遺��궛愿묒뿭�떆', '�쟾泥�', null);


INSERT INTO final_loca VALUES ('��援ш킅�뿭�떆', '以묎뎄', null);
INSERT INTO final_loca VALUES ('��援ш킅�뿭�떆', '�룞援�', null);
INSERT INTO final_loca VALUES ('��援ш킅�뿭�떆', '�꽌援�', null);
INSERT INTO final_loca VALUES ('��援ш킅�뿭�떆', '�궓援�', null);
INSERT INTO final_loca VALUES ('��援ш킅�뿭�떆', '遺곴뎄', null);
INSERT INTO final_loca VALUES ('��援ш킅�뿭�떆', '�닔�꽦援�', null);
INSERT INTO final_loca VALUES ('��援ш킅�뿭�떆', '�떖�꽌援�', null);
INSERT INTO final_loca VALUES ('��援ш킅�뿭�떆', '�떖�꽦援�', null);
INSERT INTO final_loca VALUES ('��援ш킅�뿭�떆', '援곗쐞援�', null);
INSERT INTO final_loca VALUES ('��援ш킅�뿭�떆', '�쟾泥�', null);


INSERT INTO final_loca VALUES ('�씤泥쒓킅�뿭�떆', '以묎뎄', null);
INSERT INTO final_loca VALUES ('�씤泥쒓킅�뿭�떆', '�룞援�', null);
INSERT INTO final_loca VALUES ('�씤泥쒓킅�뿭�떆', '誘몄텛��援�', null);
INSERT INTO final_loca VALUES ('�씤泥쒓킅�뿭�떆', '�뿰�닔援�', null);
INSERT INTO final_loca VALUES ('�씤泥쒓킅�뿭�떆', '�궓�룞援�', null);
INSERT INTO final_loca VALUES ('�씤泥쒓킅�뿭�떆', '遺��룊援�', null);
INSERT INTO final_loca VALUES ('�씤泥쒓킅�뿭�떆', '怨꾩뼇援�', null);
INSERT INTO final_loca VALUES ('�씤泥쒓킅�뿭�떆', '�꽌援�', null);
INSERT INTO final_loca VALUES ('�씤泥쒓킅�뿭�떆', '媛뺥솕援�', null);
INSERT INTO final_loca VALUES ('�씤泥쒓킅�뿭�떆', '�샊吏꾧뎔', null);
INSERT INTO final_loca VALUES ('�씤泥쒓킅�뿭�떆', '�쟾泥�', null);


INSERT INTO final_loca VALUES ('愿묒＜愿묒뿭�떆', '�룞援�', null);
INSERT INTO final_loca VALUES ('愿묒＜愿묒뿭�떆', '�꽌援�', null);
INSERT INTO final_loca VALUES ('愿묒＜愿묒뿭�떆', '遺곴뎄', null);
INSERT INTO final_loca VALUES ('愿묒＜愿묒뿭�떆', '�궓援�', null);
INSERT INTO final_loca VALUES ('愿묒＜愿묒뿭�떆', '愿묒궛援�', null);
INSERT INTO final_loca VALUES ('愿묒＜愿묒뿭�떆', '�쟾泥�', null);


INSERT INTO final_loca VALUES ('���쟾愿묒뿭�떆', '�룞援�', null);
INSERT INTO final_loca VALUES ('���쟾愿묒뿭�떆', '以묎뎄', null);
INSERT INTO final_loca VALUES ('���쟾愿묒뿭�떆', '�꽌援�', null);
INSERT INTO final_loca VALUES ('���쟾愿묒뿭�떆', '�쑀�꽦援�', null);
INSERT INTO final_loca VALUES ('���쟾愿묒뿭�떆', '���뜒援�', null);
INSERT INTO final_loca VALUES ('���쟾愿묒뿭�떆', '�쟾泥�', null);


INSERT INTO final_loca VALUES ('�슱�궛愿묒뿭�떆', '以묎뎄', null);
INSERT INTO final_loca VALUES ('�슱�궛愿묒뿭�떆', '�궓援�', null);
INSERT INTO final_loca VALUES ('�슱�궛愿묒뿭�떆', '�룞援�', null);
INSERT INTO final_loca VALUES ('�슱�궛愿묒뿭�떆', '遺곴뎄', null);
INSERT INTO final_loca VALUES ('�슱�궛愿묒뿭�떆', '�슱二쇨뎔', null);
INSERT INTO final_loca VALUES ('�슱�궛愿묒뿭�떆', '�쟾泥�', null);


INSERT INTO final_loca VALUES ('�꽭醫낇듅蹂꾩옄移섏떆', '�쟾泥�', null);


INSERT INTO final_loca VALUES ('寃쎄린�룄', '�닔�썝�떆', '�옣�븞援�');
INSERT INTO final_loca VALUES ('寃쎄린�룄', '�닔�썝�떆', '沅뚯꽑援�');
INSERT INTO final_loca VALUES ('寃쎄린�룄', '�닔�썝�떆', '�뙏�떖援�');
INSERT INTO final_loca VALUES ('寃쎄린�룄', '�닔�썝�떆', '�쁺�넻援�');
INSERT INTO final_loca VALUES ('寃쎄린�룄', '�닔�썝�떆', '�쟾泥�');

INSERT INTO final_loca VALUES ('寃쎄린�룄', '�꽦�궓�떆', '�닔�젙援�');
INSERT INTO final_loca VALUES ('寃쎄린�룄', '�꽦�궓�떆', '以묒썝援�');
INSERT INTO final_loca VALUES ('寃쎄린�룄', '�꽦�궓�떆', '遺꾨떦援�');
INSERT INTO final_loca VALUES ('寃쎄린�룄', '�꽦�궓�떆', '�쟾泥�');

INSERT INTO final_loca VALUES ('寃쎄린�룄', '�쓽�젙遺��떆', null);

INSERT INTO final_loca VALUES ('寃쎄린�룄', '�븞�뼇�떆', '留뚯븞援�');
INSERT INTO final_loca VALUES ('寃쎄린�룄', '�븞�뼇�떆', '�룞�븞援�');
INSERT INTO final_loca VALUES ('寃쎄린�룄', '�븞�뼇�떆', '�쟾泥�');

INSERT INTO final_loca VALUES ('寃쎄린�룄', '遺�泥쒖떆', null);
INSERT INTO final_loca VALUES ('寃쎄린�룄', '愿묐챸�떆', null);
INSERT INTO final_loca VALUES ('寃쎄린�룄', '�룞�몢泥쒖떆', null);
INSERT INTO final_loca VALUES ('寃쎄린�룄', '�룊�깮�떆', null);

INSERT INTO final_loca VALUES ('寃쎄린�룄', '�븞�궛�떆', '�긽濡앷뎄');
INSERT INTO final_loca VALUES ('寃쎄린�룄', '�븞�궛�떆', '�떒�썝援�');
INSERT INTO final_loca VALUES ('寃쎄린�룄', '�븞�궛�떆', '�쟾泥�');

INSERT INTO final_loca VALUES ('寃쎄린�룄', '怨좎뼇�떆', '�뜒�뼇援�');
INSERT INTO final_loca VALUES ('寃쎄린�룄', '怨좎뼇�떆', '�씪�궛�룞援�');
INSERT INTO final_loca VALUES ('寃쎄린�룄', '怨좎뼇�떆', '�씪�궛�꽌援�');
INSERT INTO final_loca VALUES ('寃쎄린�룄', '怨좎뼇�떆', '�쟾泥�');

INSERT INTO final_loca VALUES ('寃쎄린�룄', '怨쇱쿇�떆', null);
INSERT INTO final_loca VALUES ('寃쎄린�룄', '援щ━�떆', null);
INSERT INTO final_loca VALUES ('寃쎄린�룄', '�궓�뼇二쇱떆', null);
INSERT INTO final_loca VALUES ('寃쎄린�룄', '�삤�궛�떆', null);
INSERT INTO final_loca VALUES ('寃쎄린�룄', '�떆�씎�떆', null);
INSERT INTO final_loca VALUES ('寃쎄린�룄', '援고룷�떆', null);
INSERT INTO final_loca VALUES ('寃쎄린�룄', '�쓽�솗�떆', null);
INSERT INTO final_loca VALUES ('寃쎄린�룄', '�븯�궓�떆', null);

INSERT INTO final_loca VALUES ('寃쎄린�룄', '�슜�씤�떆', '泥섏씤援�');
INSERT INTO final_loca VALUES ('寃쎄린�룄', '�슜�씤�떆', '湲고씎援�');
INSERT INTO final_loca VALUES ('寃쎄린�룄', '�슜�씤�떆', '�닔吏�援�');
INSERT INTO final_loca VALUES ('寃쎄린�룄', '�슜�씤�떆', '�쟾泥�');

INSERT INTO final_loca VALUES ('寃쎄린�룄', '�뙆二쇱떆', null);
INSERT INTO final_loca VALUES ('寃쎄린�룄', '�씠泥쒖떆', null);
INSERT INTO final_loca VALUES ('寃쎄린�룄', '�븞�꽦�떆', null);
INSERT INTO final_loca VALUES ('寃쎄린�룄', '源��룷�떆', null);
INSERT INTO final_loca VALUES ('寃쎄린�룄', '�솕�꽦�떆', null);
INSERT INTO final_loca VALUES ('寃쎄린�룄', '愿묒＜�떆', null);
INSERT INTO final_loca VALUES ('寃쎄린�룄', '�뼇二쇱떆', null);
INSERT INTO final_loca VALUES ('寃쎄린�룄', '�룷泥쒖떆', null);
INSERT INTO final_loca VALUES ('寃쎄린�룄', '�뿬二쇱떆', null);
INSERT INTO final_loca VALUES ('寃쎄린�룄', '�뿰爾붽뎔', null);
INSERT INTO final_loca VALUES ('寃쎄린�룄', '媛��룊援�', null);
INSERT INTO final_loca VALUES ('寃쎄린�룄', '�뼇�룊援�', null);
INSERT INTO final_loca VALUES ('寃쎄린�룄', '�쟾泥�', null);


INSERT INTO final_loca VALUES ('媛뺤썝�룄', '異섏쿇�떆', null);
INSERT INTO final_loca VALUES ('媛뺤썝�룄', '�썝二쇱떆', null);
INSERT INTO final_loca VALUES ('媛뺤썝�룄', '媛뺣쫱�떆', null);
INSERT INTO final_loca VALUES ('媛뺤썝�룄', '�룞�빐�떆', null);
INSERT INTO final_loca VALUES ('媛뺤썝�룄', '�깭諛깆떆', null);
INSERT INTO final_loca VALUES ('媛뺤썝�룄', '�냽珥덉떆', null);
INSERT INTO final_loca VALUES ('媛뺤썝�룄', '�궪泥숈떆', null);

INSERT INTO final_loca VALUES ('媛뺤썝�룄', '�솉泥쒓뎔', null);
INSERT INTO final_loca VALUES ('媛뺤썝�룄', '�슒�꽦援�', null);
INSERT INTO final_loca VALUES ('媛뺤썝�룄', '�쁺�썡援�', null);
INSERT INTO final_loca VALUES ('媛뺤썝�룄', '�룊李쎄뎔', null);
INSERT INTO final_loca VALUES ('媛뺤썝�룄', '�젙�꽑援�', null);
INSERT INTO final_loca VALUES ('媛뺤썝�룄', '泥좎썝援�', null);
INSERT INTO final_loca VALUES ('媛뺤썝�룄', '�솕泥쒓뎔', null);
INSERT INTO final_loca VALUES ('媛뺤썝�룄', '�뼇援ш뎔', null);
INSERT INTO final_loca VALUES ('媛뺤썝�룄', '�씤�젣援�', null);
INSERT INTO final_loca VALUES ('媛뺤썝�룄', '怨좎꽦援�', null);
INSERT INTO final_loca VALUES ('媛뺤썝�룄', '�뼇�뼇援�', null);
INSERT INTO final_loca VALUES ('媛뺤썝�룄', '�쟾泥�', null);


INSERT INTO final_loca VALUES ('異⑹껌遺곷룄', '泥�二쇱떆', '�긽�떦援�');
INSERT INTO final_loca VALUES ('異⑹껌遺곷룄', '泥�二쇱떆', '�씎�뜒援�');
INSERT INTO final_loca VALUES ('異⑹껌遺곷룄', '泥�二쇱떆', '�꽌�썝援�');
INSERT INTO final_loca VALUES ('異⑹껌遺곷룄', '泥�二쇱떆', '泥��썝援�');
INSERT INTO final_loca VALUES ('異⑹껌遺곷룄', '泥�二쇱떆', '�쟾泥�');

INSERT INTO final_loca VALUES ('異⑹껌遺곷룄', '異⑹＜�떆', null);
INSERT INTO final_loca VALUES ('異⑹껌遺곷룄', '�젣泥쒖떆', null);

INSERT INTO final_loca VALUES ('異⑹껌遺곷룄', '蹂댁�援�', null);
INSERT INTO final_loca VALUES ('異⑹껌遺곷룄', '�삦泥쒓뎔', null);
INSERT INTO final_loca VALUES ('異⑹껌遺곷룄', '�쁺�룞援�', null);
INSERT INTO final_loca VALUES ('異⑹껌遺곷룄', '利앺룊援�', null);
INSERT INTO final_loca VALUES ('異⑹껌遺곷룄', '吏꾩쿇援�', null);
INSERT INTO final_loca VALUES ('異⑹껌遺곷룄', '愿댁궛援�', null);
INSERT INTO final_loca VALUES ('異⑹껌遺곷룄', '�쓬�꽦援�', null);
INSERT INTO final_loca VALUES ('異⑹껌遺곷룄', '�떒�뼇援�', null);
INSERT INTO final_loca VALUES ('異⑹껌遺곷룄', '�쟾泥�', null);


INSERT INTO final_loca VALUES ('異⑹껌�궓�룄', '泥쒖븞�떆', '�룞�궓援�');
INSERT INTO final_loca VALUES ('異⑹껌�궓�룄', '泥쒖븞�떆', '�꽌遺곴뎄');
INSERT INTO final_loca VALUES ('異⑹껌�궓�룄', '泥쒖븞�떆', '�쟾泥�');

INSERT INTO final_loca VALUES ('異⑹껌�궓�룄', '怨듭＜�떆', null);
INSERT INTO final_loca VALUES ('異⑹껌�궓�룄', '蹂대졊�떆', null);
INSERT INTO final_loca VALUES ('異⑹껌�궓�룄', '�븘�궛�떆', null);
INSERT INTO final_loca VALUES ('異⑹껌�궓�룄', '�꽌�궛�떆', null);
INSERT INTO final_loca VALUES ('異⑹껌�궓�룄', '�끉�궛�떆', null);
INSERT INTO final_loca VALUES ('異⑹껌�궓�룄', '怨꾨！�떆', null);
INSERT INTO final_loca VALUES ('異⑹껌�궓�룄', '�떦吏꾩떆', null);

INSERT INTO final_loca VALUES ('異⑹껌�궓�룄', '湲덉궛援�', null);
INSERT INTO final_loca VALUES ('異⑹껌�궓�룄', '遺��뿬援�', null);
INSERT INTO final_loca VALUES ('異⑹껌�궓�룄', '�꽌泥쒓뎔', null);
INSERT INTO final_loca VALUES ('異⑹껌�궓�룄', '泥��뼇援�', null);
INSERT INTO final_loca VALUES ('異⑹껌�궓�룄', '�솉�꽦援�', null);
INSERT INTO final_loca VALUES ('異⑹껌�궓�룄', '�삁�궛援�', null);
INSERT INTO final_loca VALUES ('異⑹껌�궓�룄', '�깭�븞援�', null);
INSERT INTO final_loca VALUES ('異⑹껌�궓�룄', '�쟾泥�', null);


INSERT INTO final_loca VALUES ('�쟾�씪遺곷룄', '�쟾二쇱떆', '�셿�궛援�');
INSERT INTO final_loca VALUES ('�쟾�씪遺곷룄', '�쟾二쇱떆', '�뜒吏꾧뎄');
INSERT INTO final_loca VALUES ('�쟾�씪遺곷룄', '�쟾二쇱떆', '�쟾泥�');

INSERT INTO final_loca VALUES ('�쟾�씪遺곷룄', '援곗궛�떆', null);
INSERT INTO final_loca VALUES ('�쟾�씪遺곷룄', '�씡�궛�떆', null);
INSERT INTO final_loca VALUES ('�쟾�씪遺곷룄', '�젙�쓭�떆', null);
INSERT INTO final_loca VALUES ('�쟾�씪遺곷룄', '�궓�썝�떆', null);
INSERT INTO final_loca VALUES ('�쟾�씪遺곷룄', '源��젣�떆', null);

INSERT INTO final_loca VALUES ('�쟾�씪遺곷룄', '�셿二쇨뎔', null);
INSERT INTO final_loca VALUES ('�쟾�씪遺곷룄', '吏꾩븞援�', null);
INSERT INTO final_loca VALUES ('�쟾�씪遺곷룄', '臾댁＜援�', null);
INSERT INTO final_loca VALUES ('�쟾�씪遺곷룄', '�옣�닔援�', null);
INSERT INTO final_loca VALUES ('�쟾�씪遺곷룄', '�엫�떎援�', null);
INSERT INTO final_loca VALUES ('�쟾�씪遺곷룄', '�닚李쎄뎔', null);
INSERT INTO final_loca VALUES ('�쟾�씪遺곷룄', '怨좎갹援�', null);
INSERT INTO final_loca VALUES ('�쟾�씪遺곷룄', '遺��븞援�', null);
INSERT INTO final_loca VALUES ('�쟾�씪遺곷룄', '�쟾泥�', null);


INSERT INTO final_loca VALUES ('�쟾�씪�궓�룄', '紐⑺룷�떆', null);
INSERT INTO final_loca VALUES ('�쟾�씪�궓�룄', '�뿬�닔�떆', null);
INSERT INTO final_loca VALUES ('�쟾�씪�궓�룄', '�닚泥쒖떆', null);
INSERT INTO final_loca VALUES ('�쟾�씪�궓�룄', '�굹二쇱떆', null);
INSERT INTO final_loca VALUES ('�쟾�씪�궓�룄', '愿묒뼇�떆', null);

INSERT INTO final_loca VALUES ('�쟾�씪�궓�룄', '�떞�뼇援�', null);
INSERT INTO final_loca VALUES ('�쟾�씪�궓�룄', '怨≪꽦援�', null);
INSERT INTO final_loca VALUES ('�쟾�씪�궓�룄', '援щ�援�', null);
INSERT INTO final_loca VALUES ('�쟾�씪�궓�룄', '怨좏씎援�', null);
INSERT INTO final_loca VALUES ('�쟾�씪�궓�룄', '蹂댁꽦援�', null);
INSERT INTO final_loca VALUES ('�쟾�씪�궓�룄', '�솕�닚援�', null);
INSERT INTO final_loca VALUES ('�쟾�씪�궓�룄', '�옣�씎援�', null);
INSERT INTO final_loca VALUES ('�쟾�씪�궓�룄', '媛뺤쭊援�', null);
INSERT INTO final_loca VALUES ('�쟾�씪�궓�룄', '�빐�궓援�', null);
INSERT INTO final_loca VALUES ('�쟾�씪�궓�룄', '�쁺�븫援�', null);
INSERT INTO final_loca VALUES ('�쟾�씪�궓�룄', '臾댁븞援�', null);
INSERT INTO final_loca VALUES ('�쟾�씪�궓�룄', '�븿�룊援�', null);
INSERT INTO final_loca VALUES ('�쟾�씪�궓�룄', '�쁺愿묎뎔', null);
INSERT INTO final_loca VALUES ('�쟾�씪�궓�룄', '�옣�꽦援�', null);
INSERT INTO final_loca VALUES ('�쟾�씪�궓�룄', '�셿�룄援�', null);
INSERT INTO final_loca VALUES ('�쟾�씪�궓�룄', '吏꾨룄援�', null);
INSERT INTO final_loca VALUES ('�쟾�씪�궓�룄', '�떊�븞援�', null);
INSERT INTO final_loca VALUES ('�쟾�씪�궓�룄', '�쟾泥�', null);


INSERT INTO final_loca VALUES ('寃쎌긽遺곷룄', '�룷�빆�떆', '�궓援�');
INSERT INTO final_loca VALUES ('寃쎌긽遺곷룄', '�룷�빆�떆', '遺곴뎄');
INSERT INTO final_loca VALUES ('寃쎌긽遺곷룄', '�룷�빆�떆', '�쟾泥�');

INSERT INTO final_loca VALUES ('寃쎌긽遺곷룄', '寃쎌＜�떆', null);
INSERT INTO final_loca VALUES ('寃쎌긽遺곷룄', '源�泥쒖떆', null);
INSERT INTO final_loca VALUES ('寃쎌긽遺곷룄', '�븞�룞�떆', null);
INSERT INTO final_loca VALUES ('寃쎌긽遺곷룄', '援щ�몄떆', null);
INSERT INTO final_loca VALUES ('寃쎌긽遺곷룄', '�쁺二쇱떆', null);
INSERT INTO final_loca VALUES ('寃쎌긽遺곷룄', '�쁺泥쒖떆', null);
INSERT INTO final_loca VALUES ('寃쎌긽遺곷룄', '�긽二쇱떆', null);
INSERT INTO final_loca VALUES ('寃쎌긽遺곷룄', '臾멸꼍�떆', null);
INSERT INTO final_loca VALUES ('寃쎌긽遺곷룄', '寃쎌궛�떆', null);

INSERT INTO final_loca VALUES ('寃쎌긽遺곷룄', '援곗쐞援�', null);
INSERT INTO final_loca VALUES ('寃쎌긽遺곷룄', '�쓽�꽦援�', null);
INSERT INTO final_loca VALUES ('寃쎌긽遺곷룄', '泥��넚援�', null);
INSERT INTO final_loca VALUES ('寃쎌긽遺곷룄', '�쁺�뼇援�', null);
INSERT INTO final_loca VALUES ('寃쎌긽遺곷룄', '�쁺�뜒援�', null);
INSERT INTO final_loca VALUES ('寃쎌긽遺곷룄', '泥��룄援�', null);
INSERT INTO final_loca VALUES ('寃쎌긽遺곷룄', '怨좊졊援�', null);
INSERT INTO final_loca VALUES ('寃쎌긽遺곷룄', '�꽦二쇨뎔', null);
INSERT INTO final_loca VALUES ('寃쎌긽遺곷룄', '移좉끝援�', null);
INSERT INTO final_loca VALUES ('寃쎌긽遺곷룄', '�삁泥쒓뎔', null);
INSERT INTO final_loca VALUES ('寃쎌긽遺곷룄', '遊됲솕援�', null);
INSERT INTO final_loca VALUES ('寃쎌긽遺곷룄', '�슱吏꾧뎔', null);
INSERT INTO final_loca VALUES ('寃쎌긽遺곷룄', '�슱由됯뎔', null);
INSERT INTO final_loca VALUES ('寃쎌긽遺곷룄', '�쟾泥�', null);


INSERT INTO final_loca VALUES ('寃쎌긽�궓�룄', '李쎌썝�떆', '�쓽李쎄뎄');
INSERT INTO final_loca VALUES ('寃쎌긽�궓�룄', '李쎌썝�떆', '�꽦�궛援�');
INSERT INTO final_loca VALUES ('寃쎌긽�궓�룄', '李쎌썝�떆', '留덉궛�빀�룷援�');
INSERT INTO final_loca VALUES ('寃쎌긽�궓�룄', '李쎌썝�떆', '留덉궛�쉶�썝援�');
INSERT INTO final_loca VALUES ('寃쎌긽�궓�룄', '李쎌썝�떆', '吏꾪빐援�');
INSERT INTO final_loca VALUES ('寃쎌긽�궓�룄', '李쎌썝�떆', '�쟾泥�');

INSERT INTO final_loca VALUES ('寃쎌긽�궓�룄', '吏꾩＜�떆', null);
INSERT INTO final_loca VALUES ('寃쎌긽�궓�룄', '�넻�쁺�떆', null);
INSERT INTO final_loca VALUES ('寃쎌긽�궓�룄', '�궗泥쒖떆', null);
INSERT INTO final_loca VALUES ('寃쎌긽�궓�룄', '源��빐�떆', null);
INSERT INTO final_loca VALUES ('寃쎌긽�궓�룄', '諛��뼇�떆', null);
INSERT INTO final_loca VALUES ('寃쎌긽�궓�룄', '嫄곗젣�떆', null);
INSERT INTO final_loca VALUES ('寃쎌긽�궓�룄', '�뼇�궛�떆', null);

INSERT INTO final_loca VALUES ('寃쎌긽�궓�룄', '�쓽�졊援�', null);
INSERT INTO final_loca VALUES ('寃쎌긽�궓�룄', '�븿�븞援�', null);
INSERT INTO final_loca VALUES ('寃쎌긽�궓�룄', '李쎈뀞援�', null);
INSERT INTO final_loca VALUES ('寃쎌긽�궓�룄', '怨좎꽦援�', null);
INSERT INTO final_loca VALUES ('寃쎌긽�궓�룄', '�궓�빐援�', null);
INSERT INTO final_loca VALUES ('寃쎌긽�궓�룄', '�븯�룞援�', null);
INSERT INTO final_loca VALUES ('寃쎌긽�궓�룄', '�궛泥�援�', null);
INSERT INTO final_loca VALUES ('寃쎌긽�궓�룄', '�븿�뼇援�', null);
INSERT INTO final_loca VALUES ('寃쎌긽�궓�룄', '嫄곗갹援�', null);
INSERT INTO final_loca VALUES ('寃쎌긽�궓�룄', '�빀泥쒓뎔', null);
INSERT INTO final_loca VALUES ('寃쎌긽�궓�룄', '�쟾泥�', null);


INSERT INTO final_loca VALUES ('�젣二쇳듅蹂꾩옄移섎룄', '�젣二쇱떆', null);
INSERT INTO final_loca VALUES ('�젣二쇳듅蹂꾩옄移섎룄', '�꽌洹��룷�떆', null);
INSERT INTO final_loca VALUES ('�젣二쇳듅蹂꾩옄移섎룄', '�쟾泥�', null);


DESC member;

ALTER TABLE member
	DROP COLUMN 鍮꾧퀬;
	
	
ALTER TABLE member
	DROP COLUMN pref-genre;

ALTER TABLE member
	ADD COLUMN pref_genre TEXT AFTER open;

ALTER TABLE member
	CHANGE COLUMN `pref-music` pref_music TEXT;
ALTER TABLE member
	CHANGE COLUMN `pref-day` pref_day TEXT;
ALTER TABLE member
	CHANGE COLUMN `pref-time` pref_time TEXT;


CREATE VIEW member_age AS
	SELECT member_id, FLOOR(DATEDIFF(CURRENT_DATE(),birth)/365) age FROM member;

DROP VIEW member_age;

SELECT * FROM member_age;
DESC member_age;


SELECT member_id, birth, DATEDIFF(CURRENT_DATE(),birth), FLOOR(DATEDIFF(CURRENT_DATE(),birth)/365) age FROM member WHERE birth IS NOT NULL;

SELECT member_id, inst_time, FLOOR(DATEDIFF(CURRENT_DATE(),inst_time)/30) month FROM member_inst;

CREATE VIEW inst_month AS
	SELECT member_id, inst_name, FLOOR(DATEDIFF(CURRENT_DATE(),inst_time)/30) month FROM member_inst;

SELECT * FROM inst_month;

SELECT A.*, B.month FROM member_inst A INNER JOIN inst_month B ON A.member_id = B.member_id AND A.inst_name = B.inst_name;

CREATE VIEW my_inst AS
	SELECT A.*, B.month FROM member_inst A INNER JOIN inst_month B ON A.member_id = B.member_id AND A.inst_name = B.inst_name;

SELECT * FROM member WHERE open=1;
SELECT * FROM member_loca;
SELECT * FROM member_inst;



UPDATE member_inst SET inst_level='�븯' WHERE member_id=49 AND inst_name='諛붿씠�삱由�';
UPDATE member_inst SET inst_level='以�' WHERE member_id=49 AND inst_name='�뒠諛�';
UPDATE member SET user_name='�뿀�쁽�듅' WHERE member_id=55;


INSERT INTO member_inst VALUES(13, '�씪�젆 踰좎씠�뒪', '以�', '2018-02-16');
INSERT INTO member_inst VALUES(11, '�뼱荑좎뒪�떛 湲고�', '�긽', '2018-02-16');

INSERT INTO member_loca VALUES(13, '�꽌�슱�듅蹂꾩떆', '�쟾泥�', NULL);

DELETE FROM member_loca WHERE g1="";


SELECT * FROM member 
WHERE open=1 
ORDER BY join_date DESC
LIMIT 10, 10;


DESC recruit;

ALTER TABLE recruit
	ADD COLUMN loca_g3 VARCHAR(20)
	AFTER loca_g2; 

ALTER TABLE recruit
	CHANGE COLUMN `text` free TEXT;

ALTER TABLE recruit
	DROP COLUMN duedate;

	
	

SELECT * FROM recruit_inst;
DESC recruit_inst;

ALTER TABLE recruit_inst
	MODIFY COLUMN inst_level VARCHAR(50); 
































