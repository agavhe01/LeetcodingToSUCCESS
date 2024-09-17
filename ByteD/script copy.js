function mostStreamed(videoLog, timeStamp) {
  // Convert the timestamp to a Date object for comparison
  const givenTime = new Date(timeStamp);
  const oneHourInMillis = 60 * 60 * 1000;

  // Filter the logs to include only those within the one-hour window
  let filteredLogs = videoLog.filter((log) => {
    const logTime = new Date(log.time);
    const timeDiff = Math.abs(givenTime - logTime);
    return timeDiff <= oneHourInMillis;
  });

  // Create a map to accumulate the total watch time for each videoID
  const watchTimeMap = new Map();

  filteredLogs.forEach((log) => {
    if (watchTimeMap.has(log.videoID)) {
      watchTimeMap.set(
        log.videoID,
        watchTimeMap.get(log.videoID) + log.duration
      );
    } else {
      watchTimeMap.set(log.videoID, log.duration);
    }
  });

  // Convert the map to an array and sort by total watch time (descending)
  let sortedVideos = Array.from(watchTimeMap.entries()).sort((a, b) => {
    if (b[1] === a[1]) {
      return a[0].localeCompare(b[0]); // Alphabetical order if watch times are the same
    }
    return b[1] - a[1];
  });

  // Return only the video IDs
  return sortedVideos.map((entry) => entry[0]);
}

// Test the function with the provided test cases
function main() {
  const videoLog0 = [
    { time: '2024-08-01T11:45:00Z', videoID: 'videoA', duration: 900 },
    { time: '2024-08-01T12:15:00Z', videoID: 'videoB', duration: 1200 },
    { time: '2024-08-01T12:30:00Z', videoID: 'videoA', duration: 600 },
    { time: '2024-08-01T12:55:00Z', videoID: 'videoC', duration: 1800 },
  ];
  const timeStamp0 = '2024-08-01T13:00:00Z';
  console.log(mostStreamed(videoLog0, timeStamp0)); // Output: ["videoC", "videoB", "videoA"]

  const videoLog1 = [
    { time: '2024-08-01T12:30:00Z', videoID: 'videoX', duration: 600 },
    { time: '2024-08-01T13:00:00Z', videoID: 'videoY', duration: 1200 },
    { time: '2024-08-01T13:15:00Z', videoID: 'videoX', duration: 900 },
    { time: '2024-08-01T13:45:00Z', videoID: 'videoZ', duration: 1800 },
    { time: '2024-08-01T14:15:00Z', videoID: 'videoY', duration: 600 },
  ];
  const timeStamp1 = '2024-08-01T13:30:00Z';
  console.log(mostStreamed(videoLog1, timeStamp1)); // Output: ["videoZ", "videoY", "videoX"]
}

main();
