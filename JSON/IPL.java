
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.core.type.TypeReference;
import org.apache.commons.csv.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

class IPLMatch {
    public String team1;
    public String team2;
    public String winner;
    public String playerOfMatch;
}

class IPLDataProcessor {
    private static final String REDACTED = "REDACTED";
    
    private static String maskTeamName(String name) {
        return name.replaceAll("(\w+)$", "***");
    }
    
    private static IPLMatch applyCensorship(IPLMatch match) {
        match.team1 = maskTeamName(match.team1);
        match.team2 = maskTeamName(match.team2);
        match.winner = maskTeamName(match.winner);
        match.playerOfMatch = REDACTED;
        return match;
    }

    public static List<IPLMatch> readJson(String filePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(filePath), new TypeReference<>() {});
    }
    
    public static void writeJson(List<IPLMatch> matches, String filePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(filePath), matches);
    }
    
    public static List<IPLMatch> readCsv(String filePath) throws IOException {
        List<IPLMatch> matches = new ArrayList<>();
        try (Reader reader = Files.newBufferedReader(Paths.get(filePath));
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader())) {
            for (CSVRecord record : csvParser) {
                IPLMatch match = new IPLMatch();
                match.team1 = record.get("team1");
                match.team2 = record.get("team2");
                match.winner = record.get("winner");
                match.playerOfMatch = record.get("playerOfMatch");
                matches.add(match);
            }
        }
        return matches;
    }
    
    public static void writeCsv(List<IPLMatch> matches, String filePath) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath));
             CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader("team1", "team2", "winner", "playerOfMatch"))) {
            for (IPLMatch match : matches) {
                csvPrinter.printRecord(match.team1, match.team2, match.winner, match.playerOfMatch);
            }
        }
    }

    
    public static void processJson(String inputPath, String outputPath) throws IOException {
        List<IPLMatch> matches = readJson(inputPath);
        List<IPLMatch> censoredMatches = matches.stream().map(IPLDataProcessor::applyCensorship).collect(Collectors.toList());
        writeJson(censoredMatches, outputPath);
    }
    
    public static void processCsv(String inputPath, String outputPath) throws IOException {
        List<IPLMatch> matches = readCsv(inputPath);
        List<IPLMatch> censoredMatches = matches.stream().map(IPLDataProcessor::applyCensorship).collect(Collectors.toList());
        writeCsv(censoredMatches, outputPath);
    }
}


public class Main {
    public static void main(String[] args) {
        try {
            IPLDataProcessor.processJson("ipl_matches.json", "ipl_matches_censored.json");
            IPLDataProcessor.processCsv("ipl_matches.csv", "ipl_matches_censored.csv");
            System.out.println("Censorship applied successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

