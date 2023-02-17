package parserXML;

import org.testng.annotations.Test;
import org.testng.Assert;
import xmlParser.XMLParser;


public class XMLParserTest {


    @Test
    public void testXMLParser() {
        XMLParser parser = new XMLParser("C:\\Users\\myroc\\IdeaProjects\\helloci\\Lesson7\\lesson7\\src\\main\\resources\\valid.xml");
        Assert.assertNotNull(parser);
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void testXMLParserWithNull() {
        XMLParser parser = new XMLParser(null);
    }

    //баг 1: Отображается ошибка "Unexpected closing tag catalog" в валидном xml файле.
    @Test
    public void testParseDocument_withValidFile() {
        XMLParser parser = new XMLParser("C:\\Users\\myroc\\IdeaProjects\\helloci\\Lesson7\\lesson7\\src\\main\\resources\\valid.xml");
        parser.parseDocument();

        Assert.assertEquals(parser.getErrors().size(), 0, "Should have no errors");
    }

    //баг 2: Неверно определяет незакрытый тэг(при отсутствии закрытого тэга "price" определяет как "Unexpected closing tag book").
    @Test
    public void testParseDocument_noCloseTag() {
        XMLParser parser = new XMLParser("C:\\Users\\myroc\\IdeaProjects\\helloci\\Lesson7\\lesson7\\src\\main\\resources\\noCloseTag.xml");
        parser.parseDocument();
        Assert.assertEquals(parser.getErrors().size(), 1, "Should have 1 error");
        Assert.assertEquals(parser.getErrors().get(0), "Tag price name never closed. Tag names must have format <name>.");
    }

    //баг 3: Отсутствие "/" в закрытом тэге "name" определяет как "Unexpected closing tag book".
    @Test
    public void testParseDocument_noSlashTag() {
        XMLParser parser = new XMLParser("C:\\Users\\myroc\\IdeaProjects\\helloci\\Lesson7\\lesson7\\src\\main\\resources\\noSlashTag.xml");
        parser.parseDocument();
        Assert.assertEquals(parser.getErrors().size(), 1, "Should have 1 error");
        Assert.assertEquals(parser.getErrors().get(0), "Tag name name never closed. Tag names must have format <name>.");
    }

    // ожидаемый результат: 1 ошибка - фактический результат: 2 ошибки (связано с "Баг 1")
    @Test
    public void testParseDocument_noInstructionTag() {
        XMLParser parser = new XMLParser("C:\\Users\\myroc\\IdeaProjects\\helloci\\Lesson7\\lesson7\\src\\main\\resources\\noInstructionTag.xml");
        parser.parseDocument();
        Assert.assertEquals(parser.getErrors().size(), 1, "Should have 1 error");
        Assert.assertEquals(parser.getErrors().get(0), "Instruction tag is not closed");
    }


}
